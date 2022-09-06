#server.py
import socket
import threading
import GrotonChatCensor
from signal import signal, SIGPIPE, SIG_DFL

def accept_loop(my_socket, broadcast_list):
    while True:
        my_socket.listen()
        client, client_address = my_socket.accept()
        broadcast_list.append(client)
        start_listenning_thread(client, broadcast_list)

def start_listenning_thread(client, broadcast_list):
    client_thread = threading.Thread(
            target=listen_thread,
            args=(client, broadcast_list) #the list of argument for the function
        )
    client_thread.start()

def listen_thread(client, broadcast_list):
    while True:
        message = client.recv(1024).decode()
        if message:
            print(f"Received message : {message}")
            username, score, adjustment, messages = GrotonChatCensor.score(message)
            if type(messages)==str:
                messages = [messages]
            if(username == "<ADMIN>"):
                client.send(((username+" ").rjust(16)+messages[0].ljust(40)).encode())
            else:
                broadcast(("["+username+":%0.2f] "%score).rjust(16) +  messages[0].ljust(40), broadcast_list)
                for i in range(1, len(messages)):
                    broadcast((" ").ljust(16) +  messages[i].ljust(40), broadcast_list)

        else:
            print(f"client has been disconnected : {client}")
            broadcast_list.remove(client)
            return

def broadcast(message, broadcast_list):
    for client in broadcast_list:
        try:
            client.send(message.encode())
        except Exception as e:
            print(e)
            broadcast_list.remove(client)
            print(f"Client removed : {client}")

def run():
    my_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    PORT = 8000
    ADDRESS = "0.0.0.0"
    broadcast_list = []
    my_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    my_socket.bind((ADDRESS, PORT))
    print("Server started")
    accept_loop(my_socket, broadcast_list)

if __name__ == "__main__":
    signal(SIGPIPE,SIG_DFL)
    run()

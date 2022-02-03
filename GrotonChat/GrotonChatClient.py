#client.py
import socket
import threading
from signal import signal, SIGPIPE, SIG_DFL
import GrotonChatGUI

def thread_sending(my_socket, outbound_messages, nickname):
    while True:
        if len(outbound_messages) > 0:
            message_to_send = outbound_messages.pop(0)
            message_with_nickname = nickname + "\t" + message_to_send
            my_socket.send(message_with_nickname.encode())

def thread_receiving(my_socket, inbound_messages):
    while True:
        message = my_socket.recv(1024).decode()
        inbound_messages.append(message)

def run():
    my_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # Extra Credit Opportunity: Allow the user to specify
    # the host IP address as a command line argument.
    host = "localhost" # "127.0.1.1"
    port = 8000
    my_socket.connect((host, port))

    inbound_messages = []
    outbound_messages = []

    # Extra Credit Opportunity: The code below launches
    # the client's GUI.  Add a command line flag that suppresses
    # it and runs a command line version of the client.
    nickname = GrotonChatGUI.get_nickname()
    thread_send = threading.Thread(target=thread_sending, args=(my_socket, outbound_messages, nickname))
    thread_receive = threading.Thread(target=thread_receiving, args=(my_socket, inbound_messages))
    thread_send.start()
    thread_receive.start()
    
    GrotonChatGUI.run(inbound_messages, outbound_messages)

if __name__ == "__main__":
    signal(SIGPIPE,SIG_DFL)
    run()

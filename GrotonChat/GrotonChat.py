import GrotonChatServer
import GrotonChatClient
import threading
from signal import signal, SIGPIPE, SIG_DFL


if __name__ == "__main__":
    signal(SIGPIPE,SIG_DFL)
    server = threading.Thread(target=GrotonChatServer.run)
    server.start()
    GrotonChatClient.run()

import os

def main():
    print("Hi World from Python!")
    

    print(os.listdir("/data"))
    # print(os.path.getsize("/data/html_conten.txt"))
    with open("/data/html_conten.txt", "r") as file:
        content = file.read()
        print(content)

if __name__ == "__main__": 
    main()
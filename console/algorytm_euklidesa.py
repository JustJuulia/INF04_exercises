def euklides(a, b):
    while True:
        if a != b:
            if a > b:
                a = a - b
            else:
                b = b - a
        else:
            return a
            break



a = int(input("Wprowadź a: "))
b = int(input("Wprowadź b: "))
print(euklides(a, b))

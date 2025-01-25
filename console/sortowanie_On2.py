class SelectionSorter:
    def __init__(self):
        self.array = []

    def find_max_index(self, start_index):
        max_index = start_index
        for i in range(start_index + 1, len(self.array)):
            if self.array[i] > self.array[max_index]:
                max_index = i
        return max_index

    def sort_descending(self):
        for i in range(len(self.array)):
            max_index = self.find_max_index(i)
            self.array[i], self.array[max_index] = self.array[max_index], self.array[i]

    def input_array(self):
        print("Wprowadź 10 liczb całkowitych do posortowania:")
        for i in range(10):
            while True:
                try:
                    number = int(input(f"Podaj liczbę {i + 1}: "))
                    self.array.append(number)
                    break
                except ValueError:
                    print("Nieprawidłowa wartość. Podaj liczbę całkowitą.")

    def display_array(self):
        print("Posortowana tablica (malejąco):")
        print(" ".join(map(str, self.array)))

sorter = SelectionSorter()
sorter.input_array()
sorter.sort_descending()
sorter.display_array()

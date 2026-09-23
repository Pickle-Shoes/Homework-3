import random
import time

data_list = []
sorted_list = []
max_iterations = 10
increase = 50000
high = 5000

#I got this next chunk of code from geeks for geeks
# partition function
def partition(arr, low, high):
    
    # choose the pivot
    pivot = arr[high]
    
    # index of smaller element and indicates 
    # the right position of pivot found so far
    i = low - 1
    
    # traverse arr[low..high] and move all smaller
    # elements to the left side. Elements from low to 
    # i are smaller after every iteration
    for j in range(low, high):
        if arr[j] < pivot:
            i += 1
            swap(arr, i, j)
    
    # move pivot after smaller elements and
    # return its position
    swap(arr, i + 1, high)
    return i + 1

# swap function
def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]

# the QuickSort function implementation
def quickSort(arr, low, high):
    if low < high:
        
        # pi is the partition return index of pivot
        pi = partition(arr, low, high)
        
        # recursion calls for smaller elements
        # and greater or equals elements
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)


#quickSort(arr, 0, n - 1) how to call
    

#everything above this is from geeksforgeeks

def generate_data():
    global sorted_list
    for i in range(1, max_iterations + 1 ):

        data_list.extend([None]*increase)  #creates 50000 new spaces at end of list
        for k in range((i-1)*increase, i*increase):
            data_list[k] = random.randint(1, high) #fill with random data
        sorted_list = data_list.copy()
        start_time = time.perf_counter()
        quickSort(sorted_list, 1, i * increase - 1)
        end_time = time.perf_counter()
        execution_time = (end_time - start_time) * 1000
        print("Data set: ", i, f"Execution time: {execution_time:.6f} ms. Data Size: {i * increase}")


#print(len(sorted_list))
#print(len(data_list))
generate_data()
#print(len(data_list))
#print(len(sorted_list))
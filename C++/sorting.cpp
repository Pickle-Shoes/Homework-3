#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <algorithm>
#include <vector>
#include <chrono>

using namespace std;

int main(){

    // Define Data Size
    int max = 10;
    int increase = 50000;
    int high = 5000;

    // Create Empty Vectors
    vector<int> data, sorted;

    // Seed the Randomizer from time
    srand(time(NULL));

    // Creating the data set
    for(int n = 1; n <= max; n++)
    {
        data.resize(n * increase);
        for(int loop = (n - 1) * increase; loop < n * increase; loop++)
        {
            data[loop] = rand() % high + 1;
        }

        // Sort the vector (using quick sort) and time it
        sorted.resize(n * increase);
        sorted = data;
        auto start = chrono::high_resolution_clock::now();
        sort(sorted.begin(), sorted.end());
        auto end = chrono::high_resolution_clock::now();

        auto duration = chrono::duration_cast<chrono::milliseconds>(end - start);
        cout << "Data Set (" << n << ") Time: " << duration.count() << "ms. Data Size: " << increase * n << "." << endl;
    }

    return 0;
}
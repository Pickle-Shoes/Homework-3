#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <algorithm>
#include <vector>
#include <chrono>

using namespace std;

int main(){

    // Create Empty Vectors
    vector<int> data, sorted;

    // Seed the Randomizer from time
    srand(time(NULL));

    // Creating the data set
    for(int n = 0; n < 10; n++)
    {
        data.resize(n);
        for(int loop = (n - 1) * 50; loop < n * 50; loop++)
        {
            data[loop] = rand() % 5000 + 1;
        }

        // Sort the vector (using quick sort) and time it
        auto start = chrono::high_resolution_clock::now();
        sorted = data;
        sort(sorted.begin(), sorted.end());
        auto end = chrono::high_resolution_clock::now();

        auto duration = chrono::duration_cast<chrono::milliseconds>(end - start);
        cout << "Data Set (" << n + 1 << ") Time: " << duration.count() << "ms." << endl;
    }

    return 0;
}
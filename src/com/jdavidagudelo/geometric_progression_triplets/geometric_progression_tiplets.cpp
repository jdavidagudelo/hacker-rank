
// C++ program to find if there exist three elements in
// Geometric Progression or not
#include <iostream>
using namespace std;

// The function prints three elements in GP if exists
// Assumption: arr[0..n-1] is sorted.
void findGeometricTriplets(int arr[], int n)
{
    // One by fix every element as middle element
    for (int j = 1; j < n - 1; j++)
    {
        // Initialize i and k for the current j
        int i = j - 1, k = j + 1;

        // Find all i and k such that (i, j, k)
        // forms a triplet of GP
        while (i >= 0 && k <= n - 1)
        {
            // if arr[j]/arr[i] = r and arr[k]/arr[j] = r
            // and r is an integer (i, j, k) forms Geometric
            // Progression
            while (arr[j] % arr[i] == 0 &&
                    arr[k] % arr[j] == 0 &&
                    arr[j] / arr[i] == arr[k] / arr[j])
            {
                // print the triplet
                cout << arr[i] << " " << arr[j]
                     << " " << arr[k] << endl;

                // Since the array is sorted and elements
                // are distinct.
                k++ , i--;
            }

            // if arr[j] is multiple of arr[i] and arr[k] is
            // multiple of arr[j], then arr[j] / arr[i] !=
            // arr[k] / arr[j]. We compare their values to
            // move to next k or previous i.
            if(arr[j] % arr[i] == 0 &&
                    arr[k] % arr[j] == 0)
            {
                if(arr[j] / arr[i] < arr[k] / arr[j])
                    i--;
                else k++;
            }

            // else if arr[j] is multiple of arr[i], then
            // try next k. Else, try previous i.
            else if (arr[j] % arr[i] == 0)
                k++;
            else i--;
        }
    }
}

// Driver code
int main()
{
    // int arr[] = {1, 2, 6, 10, 18, 54};
    // int arr[] = {2, 8, 10, 15, 16, 30, 32, 64};
    // int arr[] = {1, 2, 6, 18, 36, 54};
    int arr[] = {1, 2, 4, 16};
    // int arr[] = {1, 2, 3, 6, 18, 22};
    int n = sizeof(arr) / sizeof(arr[0]);

    findGeometricTriplets(arr, n);

    return 0;
}

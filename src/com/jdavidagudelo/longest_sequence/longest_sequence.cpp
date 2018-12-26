
// CPP program to find longest running sequence
// of positive integers.
#include <bits/stdc++.h>
using namespace std;

// Prints longest sequence of positive integers in
// an array.
void getLongestSeq(int a[], int n)
{
    // Variables to keep track of maximum length and
    // starting point of maximum length. And same
    // for current length.
    int maxIdx = 0, maxLen = 0, currLen = 0, currIdx = 0;

    for (int k = 0; k < n; k++) {
        if (a[k] > 0) {
            currLen++;

            // New sequence, store
            // beginning index.
            if (currLen == 1)
                currIdx = k;
        }
        else {
            if (currLen > maxLen) {
                maxLen = currLen;
                maxIdx = currIdx;
            }
            currLen  = 0;
        }
    }

    if (maxLen > 0)
        cout << "Length " << maxLen
             << ", starting index " << maxIdx << endl;
    else
        cout << "No positive sequence detected." << endl;

    return;
}

// Driver code
int main()
{
    int arr[] = { 1, 2, -3, 2, 3, 4, -6,
               1, 2, 3, 4, 5, -8, 5, 6 };
    int n = sizeof(arr) / sizeof(int);
    getLongestSeq(arr, n);
    return 0;
}

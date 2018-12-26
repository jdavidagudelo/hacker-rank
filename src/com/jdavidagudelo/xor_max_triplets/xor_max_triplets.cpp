// C++ implementation of the approach
#include <bits/stdc++.h>
using namespace std;

// function to count maximum
// XOR value for a triplet
void Maximum_xor_Triplet(int n, int a[])
{
    // set is used to avoid repetitions
    set<int> s;

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {

            // store all possible unique
            // XOR value of pairs
            s.insert(a[i] ^ a[j]);
        }
    }

    int ans = 0;

    for (auto i : s) {
        for (int j = 0; j < n; j++) {

            // store maximum value
            ans = max(ans, i ^ a[j]);
        }
    }

    cout << ans << "\n";
}

// Driver code
int main()
{
    int a[] = { 1, 3, 8, 15 };
    int n = sizeof(a) / sizeof(a[0]);
    Maximum_xor_Triplet(n, a);

    return 0;
}
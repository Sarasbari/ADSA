#include <bits/stdc++.h>
using namespace std;

void merge(int arr[], int left, int mid, int right);

void mergesort(int arr[], int left, int right)
{
    if (left < right)
    {
        int mid = (left + right) / 2;
        mergesort(arr, left, mid);
        mergesort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

void merge(int arr[], int left, int mid, int right){
    int i=left , j = mid+1, temp=0;
    int b[100];

    while(i<=mid && j<=right){
        if(arr[i] <= arr[j]){
            b[temp++] = arr[i++];
        }else{
            b[temp++] = arr[j++];
        }
    }
    while(i<=mid){
        b[temp++] = arr[i++];
    }
    while(j<=right){
        b[temp++] = arr[j++];
    }
    for(int k=0;k<temp;k++){
        arr[left+k] = b[k];
    }

}

int main()
{
    int arr[] = {24, 1, 52, 7, 4, 2};
    cout << "Before sorting:\n";
    for(int i=0;i<6;i++){
        cout << arr[i] << " ";
    }
    cout << endl;

    mergesort(arr,0,9);

    cout << "After sorting:\n";
    for(int i=0;i<6;i++){
        cout << arr[i] << " ";
    }
    cout << endl;

    return 0;
}
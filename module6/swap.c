#include <stdio.h>

void swap(int *a, int *b)
{
    int temp = *a;      //temp spot, next copy b into A
    *a = *b;            //next copy the contents in temp too b.
    *b = temp;
}

void broken_swap(int a, int b)
{
    int temp = a;               //the swap happened in the function, but the values never got back to main
    a = b;
    b = a;                     //I could print it here, but in main i still have orig values.
}

int main()
{
    int var1 = 13;
    int var2 = 87012;

    printf("Variable 1 = %8d\n", var1);
    printf("Variable 2 = %8d\n", var2);
    printf("Calling swap \n");
    broken_swap(var1, var2);    //If I printed the values in the method, I would see the swap.
    printf("After swap \n");
    printf("Variable 1 = %8d\n", var1);
    printf("Variable 2 = %8d\n", var2);
    
    return 0;
}
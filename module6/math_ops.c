#include <stdio.h>

void print_math(int a, int b)
{
    int sum = a + b ;
    int product = a * b;
    printf("Sum:%8d\n", sum);
    printf("Product:%4d\n", product); 
}

int main() 
{
    int first;
    int second;
    printf("Enter first number:   ");
    scanf("%d", &first);
    printf("Enter second number:  ");
    scanf("%d", &second);

    print_math(first, second);

    return 0;
}

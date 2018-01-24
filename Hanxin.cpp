#include<stdio.h>
#include"stdafx.h"

int main() {
	int a, b, c;
	int count = 0;
	while (scanf_s("%d %d %d", &a, &b, &c)) {
		count++;
		if (a >= 3 || b >= 5 || c > +7) {
			printf("Case %d:No answer", count);
		}
		else {
			bool ifFind = false;
			for (int i = 10; i <= 100; i++) {
				if (i % 3 == a && i % 5 == b && i % 7 == c) {
					printf("Case %d: %d", count,i);
					ifFind = true;
				}
			}
			if(!ifFind)
				printf("Case %d:No answer", count);
		}
	 }
	return 0;

}
/*
 * test.cpp
 *
 *  Created on: 2019��1��4��
 *      Author: Administrator
 */

#include<iostream>
using namespace std;
int main() {
	int n,m;
	cin >> n >>m;

	char a[100][100];
	for (int i = 0; i < n; ++i) {
		cin >> a[i];
	}

	for (int i = 0; i < n; ++i) {
		cout << a[i];
	}


}



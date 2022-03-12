/*
 * addandmultiply.cpp
 *
 *  Created on: 2019年1月2日
 *      Author: wolf
 */

#include<iostream>
using namespace std;

int addandmultiply(int argc, char **argv) {
	int a, b, c;
	cin >> a >> b >> c;

	int l = a + b * c;
	l = l > (a + b) * c ? l : (a + b) * c;
	l = l > a * b + c ? l : a * b + c;
	l = l > a * (b + c) ? l : a * (b + c);
	l = l > a + b + c ? l : a + b + c;
	l = l > a * b * c ? l : a * b * c;
	cout << l;
}


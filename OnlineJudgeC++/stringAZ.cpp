#include<iostream>
#include<vector>
using namespace std;
    void solve(int n, int m, long long k) {
        vector<char> x;//
        while (n && m) {
            //ÿ�ε��������ģ����һ����λ
            ////�������:���赱ǰ�������ַ�Ϊa��ʣ��n-1��a����ʣ��n - 1 +m ��λ�ù��еĿ�����
            long long count = 1;
            for (int i = 0; i < n - 1; i++) {//�������
                count *= n - 1 + m - i;
                count /= (i + 1);
                if (count > k)break;//��ֹԽ�硣count>k�Ϳ����˳�������
            }
            if (k <= count) {//���kС�ڵ���count����������ַ���ȷӦΪa
                x.push_back('a');
                n--;//��������Ϊ n-1��a��m��z ���ҵ�k��
            }
            else {
                x.push_back('z');
                m--;//��������Ϊ n-1��a��m��z ���ҵ�k-count��
                k -= count;
            }
        }
        //ѭ��������ʣ��������ֻ����"aa..aaa" �� "zz..zzz"1�����
        if (k != 1) {//
            cout << -1;
            return;
        }
        while (n--)x.push_back('a');
        while (m--)x.push_back('z');
        for (int i = 0; i < x.size(); i++) {
            cout << x[i];
        }
    }
int stringAZ() {
    int n, m;
    long long k;
    while (cin >> n >> m >> k) {
        solve(n, m, k);
    }
    return 0;
}

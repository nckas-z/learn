#define MAXSIZE 50
typedef int ElemType ;
#include <stdio.h>
#include <iostream>

//静态分配
typedef struct{
    ElemType data[MAXSIZE];
    int length;
}SqList;

//动态分配
typedef struct{
    ElemType * data;
    int maxSize;//最大容量
    int length;//当前长度
}SeqList;


//静态分配初始化
void InitList(SqList &L){
    L.length=0;
}

//动态分配初始化
void s_InitList(SeqList &L){
	L.data = (ElemType*)malloc(MAXSIZE * sizeof(ElemType));
	L.length = 0;
	L.maxSize = MAXSIZE;
}

/*
* 插入操作
*/
bool ListInsert(SqList& L, int i, ElemType e) {
	if (i<1 || i>L.length + 1) {
		printf("插入位置不合法");
		return false;
	}
	if (L.length >= MAXSIZE) {
		printf("顺序表已满，无法插入");
		return false;
	}
	for (int j = L.length; j >= i;j--){
		L.data[j] = L.data[j - 1];
	}
	L.data[i - 1] = e;
	L.length++;
	return true;
}

/*
* 删除操作
*/
bool ListDelete(SqList& L, int i, ElemType& e) {
	if (i<1 || i>L.length) {
		printf("删除位置不合法");
		return false;
	}
	e = L.data[i - 1];
	for (int j = i;j > L.length;j++){
		L.data[j - 1] = L.data[j];
	}
	return true;
}

/*
* 按值查找
*/
int LocateElem(SqList &L, ElemType e){
	for (int i = 0;i < L.length;i++){
		if (e == L.data[i]) {
			return i + 1;
		}
	}
	return 0;
}
#define MAXSIZE 50
typedef int ElemType ;
#include <stdio.h>

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
    L.data=(ElemType*)
}
# feed-the
feed the baby patch
#include<stdio.h>

int main(){
	int students;
	int age,height;
	int count,weight;
	int avgage,avgheight,avgweight;
	count=0;
		
	for(count=0;count<=20;count++){
		printf("input student\n");
		scanf("%d",&students);
		}
		for(count=0;count<=20;count++){
		
		printf("input age\n");
		scanf("%d",age);
		++age;}
		for(count=0;count<=20;count++){
		
		printf("input height\n");
		scanf("%d",height);
		++height;}
		for(count=0;count<=20;count++){
		
		printf("input weight\n");
		scanf("input weight %d",weight);
	

	}
	avgage=age/count;
	printf("the average age is :%d\n",avgage);
	avgheight=height/count;
	printf("the average height is ;%d\n",avgheight);
	avgweight=weight/count;
	printf("the average weight is :%d\n");
	
return 0;	
}

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int search(int);
int display();
int back();
int check(int);       
int value=0;

struct node {
	int ID;
	char proName[100];
	float prePrice;            
	int quantity;
struct    node* next; //struct data type cha ptr define kela ahe next navani jo pudchya node cha address store karel
}*tem,*head=NULL;


 void beg()
{
	int id,quant;          
	char name[100];
	float pre;           
	struct node* t = (struct node*) malloc(sizeof(struct node));
	t->next=0;


	printf("\t\t\tEnter product ID:-");
	scanf("%d",&id);
	t->ID=id;
	printf("\t\t\tEnter product Name:-");
	scanf("%s",name);
	for(int i=0;i<100;i++){
	t->proName[i]=name[i];}
	printf("\t\t\tEnter product price:-");
	scanf("%f",&pre);
	t->prePrice=pre;
	printf("\t\t\tEnter product quantity:-");
	scanf("%d",&quant);
	t->quantity=quant;
	
	if(head==0){
	    head=tem=t;
	}
	else{
	    tem->next=t;
	    tem=t;
	}


		printf("\n\n\t\t\t\tThis product is Inserted!\n\n\n");
	}

	void delPro()
	{
		display();
		int id;
		struct node *cur=head;
		struct node *pre=head;
		printf("\n\nEnter ID to delete that product:\n\n");
		scanf("%d",&id);
		 if (head == NULL)
        {
            printf("List is empty\n");
        }
        else{
	int pos=0;
	int count=display();               
	pos=search(id);                         
	if(pos<=count){

		while(cur->ID!=id){               
			pre=cur;
			cur=cur->next;
}
		pre->next=cur->next;
		free(cur);
		printf("\n<<item is deleted>>\n");
	}else{
		printf("\n<<<Not found>>\n\n");
	}
        }
	}
	void modify(){
		int id;
		float pre;        
		char pName[100];     
		if (head == NULL)
    {
        printf("List is empty\n");
    }else
	{
		printf("\n\nEnter ID to modify product Name and its price:\n");
		scanf("%d",&id);
		struct node *cur=head;
		int pos=0;
		int count=display();               
	pos=search(id);                       
	if(pos<=count){

		while(cur->ID!=id){
			cur=cur->next;
		}
		printf("\nOld Name : ");
		printf("%s",cur->proName);
		printf("\nOld Price : ");
		printf("%.2f\n",cur->prePrice);
		printf("Enter new Name: ");
		scanf("%s",pName);
		for(int i=0;i<100;i++){
		cur->proName[i]=pName[i];}
		printf("Enter new Price:");
		scanf("%f",&pre);
		cur->prePrice=pre;
	}else{
	    printf("%d is <<Not found>>\n\n",id);
	}
	}
}
int display(){
		int c=0;             
		struct node *p=head;
		printf("Existing products are:\n");
		printf("ID\t\t\tProduct Name\t\t\t\tPrice\t\t\t\tQuantity\n");
		while(p!=NULL)
		{
		    printf("%d\t\t\t%s\t\t\t\t\t%.2f\t\t\t\t",p->ID,p->proName,p->prePrice);   
            if(check(p->quantity)<=0)
                printf("OUT OF STOCK!\n");
            else
                printf("%d\n",check(p->quantity));
			p=p->next;
			c=c+1;
		}
		printf("\nTotal products in our store is : %d\n\n\n",c);
		return c;
	    }
int check(int quant){              
    int a = quant;
        if(quant<=0)
            return 0;
        else
	    	return quant;
		}
void buy(){
		int pay=0,no,price,id,i=1;
    if(head==NULL) {
        printf("\n<<<<There is no items to buy>>>>\n\n");
	}
	else{
		printf("How many items you want to buy!\n");
		scanf("%d",&no);
			int count=display();          
    while (i<=no){
        struct node *cur=head;

        int quant;              
        printf("Enter id of item that you want to buy: ");
        int id,pos=0;
        scanf("%d",&id);
        pos=search(id);
        if(pos<=count){

		while(cur->ID!=id){
			cur=cur->next;
		}
        printf("How many quantities you want:");
        scanf("%d",&quant);
        pay=pay+(cur->prePrice*quant);         
        cur->quantity=cur->quantity-quant;           
        i++;
        printf("\n\n\t\t\tYou have bought : ");
        printf("%s\n\n",cur->proName);
	}
	else{
		printf("\n<<<<<<<<<This item is not available in our store at this time>>>>\n\n");
	    }
}
}
    price=pay*(0.90);        
	printf("\n\n\t\t\t\t\tOriginal price : %d\n",pay);
    printf("\t\t\t\t\twith 10 percent discount:   %d\n\t\t\t\t\tThank you! for the shopping\n\n",price);
}


	int search(int id)                     
 {
 	int count=1;
 	struct node *p=head;
 	while(p!=NULL)
 	{
 		if(p->ID==id)
 			break;
 		else
 			count++;
 			p=p->next;
	}
 	return count;
 }
 int back()
 {
     int no,i=1;
     float give=0;
     printf("How many items you want to return!\n");
		scanf("%d",&no);
		int count=display();
		while (i<=no){
			struct node *cur=head;
			int quant,cho;             
			
    printf("Enter the id of product you want to return");
    int id,pos=0;
	scanf("%d",&id);
	pos=search(id);
	if(pos<=count){
	                       
		while(cur->ID!=id){
			cur=cur->next;
		}
    printf("\n\nHow many quantities you want to return\n\n");
	scanf("%d",&quant);
    give=give+(cur->prePrice*quant);         
	cur->quantity=cur->quantity+quant;
	i++;
	}
		}
		printf("\n\n\t\t\t\tYou will get %.2f rs back",(give*0.9));
    
 }
	                        
int main(){
    int flag,flag1;
    printf("<<<<<<<<<<<<<<<<<<<<<<<<   SuperMarket   >>>>>>>>>>>>>>>>>>>>\n");             
	printf("<<<<<<<<<<<<<<<<<<<<<<<<   Store         >>>>>>>>>>>>>>>>>>>>\n\n\n");
	int temp=1;
	while(1)
    {
    int cm;
    flag=1;
    flag1=1;
	printf("\t\tEnter 1 for Shopkeeper portal \n\n\t\tEnter 2 for Customer portal\n\n\t\tEnter 0 for exit\n\n");
		printf("\nENTER : ");
//	printf(">>>>>**>>>>>>>>");
	scanf("%d",&cm);
	switch(cm)
	{
    case 1 :
    while(flag){
	int ch;                    
	printf("\n\n\t\tEnter 1 for ADD a new product \n\n\t\tEnter 2 to display all products \n\n\t\tEnter 3 for MODIFY Existing product\n\n");
	printf("\t\tEnter 4 for Delete a particular product item\n\n\t\tEnter 0 for exit\n\n");
	
	printf("\nENTER : ");
//	printf(">>>>>**>>>>>>>>");
    scanf("%d",&ch);
	switch(ch){
	case 1:
	beg();

	break;
    case 2:
	display();
    break;
    case 3:
	modify();
	break;
    case 4:
	delPro();
	break;
    case 0:
        printf("Exiting...\n");
	    flag=0;                
        break;
    default:
        
         printf("\t\t<<<Wrong choice>>>\n\n");
         break;
	}
	}
break;
case 2:
    while(flag1)
    {
        int cd;
      printf("\n\n\t\tEnter 1 To buy something\n\n\t\tEnter 2 to return something\n\n\t\tEnter 0 for exit\n\n");
      	printf("\nENTER : ");

   //   printf(">>>>>**>>>>>>>>");
      scanf("%d",&cd);
       switch(cd)
       {
       case 1 :
           buy();
	       break;
       case 2 :
        back();
        break;
       case 0 :
        printf("Exiting...\n");
	    flag1 = 0;                   
        break;
        default: 
           printf("\t\t<<<Wrong choice>>>\n\n");
           break;
       }
    }break;
    case 0 :
        printf("Exiting...\n");
	    exit(1);                    
        break;
    default: 
        printf("\t\t<<<Wrong choice>>>\n\n");
        break;

}
    }
}
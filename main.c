#include <stdio.h>
#include <stdlib.h>

typedef struct data
{
    char kar;
    struct data *next, *prev;
}data;

data *head=NULL, *hapus, *temp, *baru, *lihat;

int main()
{
    int n, i=0, pil,status=0;
    printf("Jumlah inputan: ");
    scanf("%d", &n);
    while(i<n)
    {
        system("cls");
        printf("Pilihan:\n");
        printf("1. Add  2. Print  3. Delete\n");
        printf("4. Shift R  5. Shift L  6. Exit\n");
        printf("Pilihan Anda: ");
        scanf("%d", &pil);
        if(pil==1)
        {
            baru=(data *)malloc(sizeof(data));
            fflush(stdin);
            printf("enter your char: ");
            scanf("%c", &baru->kar);
            if(head==NULL)
            {
                head=baru; temp=baru;
                baru->prev=NULL;baru->next=NULL;
            }
            else if(status == 0)
            {
                baru->next=temp->next; //null
                baru->prev = temp;
                temp->next = baru;
                temp=temp->next;
            }
            else if(status == 1)
            {
                baru->next=temp;
                baru->prev=temp->prev;
                temp->prev = baru;
                lihat = baru->prev;
                if(lihat != NULL)
                    lihat->next = baru;
                else
                    head = baru;
            }
        }
        if(pil==2)
        {
            lihat=head;
            if(lihat==NULL)
            	printf("Data Kosong\n!");
			while(lihat!=NULL)
            {
                printf("%c ", lihat->kar);
                lihat=lihat->next;
            }
            
            getch();
        }
        if(pil==3)
        {
            if(head!=NULL)
            {
                if(status==0)
                {
                    hapus = temp;
                    printf("Karakter %c sudah dihapus", hapus->kar);
                    getch();
                    if(hapus == head)
                    {
                        temp = temp->next;
                        hapus = head;
                        head = hapus;
                        if(head!=NULL)
                            head->prev=NULL;
                    }
                    else
                    {
                        temp = temp->prev;
                        temp->next = hapus->next;
                        if(hapus->next!=NULL)
						{
							hapus->next->prev =temp;
						}
                    }
                    free(hapus);
                }
                else if(temp != head)
                {
                    hapus = temp->prev;
                    printf("Karakter %c sudah dihapus", hapus->kar);
                    getch();
                    if(hapus->prev!=NULL)
                    {
                        hapus->prev->next=temp;
                        temp->prev = hapus->prev;
                    }
                    else
                    {
                        temp->prev = NULL;
                        head = temp;
                    }
                    free(hapus);
                }
            }
        }
        else if(pil == 4)
        {
            if(status == 1)
                status = 0 ;
            else
                if(temp->next ==NULL)
                {
                    printf("linked list sudah paling kanan");
                    getch();
                }
                else
                    temp = temp->next;
        }
        else if(pil == 5)
        {
            if(status == 0)
                status = 1 ;
            else
                temp = temp->prev;
        }
        else if(pil == 6)
        {
        	return 0;
		}
        i++;
    }
    printf("\n\tJumlah inputan sudah maksimal\n");
    return 0;
}

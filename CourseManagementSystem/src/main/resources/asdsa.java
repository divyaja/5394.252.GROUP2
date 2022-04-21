// Lab 11
// Spring 2022

#include<iostream> // for NULL
using namespace std;

class NumberList {
	private:
	struct ListNode // a data type
	{
        double value;
        struct ListNode *next;
    };ListNode*head;

	void append (double,ListNode*&);

	public:NumberList();~NumberList();

	void appendNode(double);

	void displayList();

	int rsearch(double);
};

	NumberList::

	NumberList() {
		head = NULL;
	}

	NumberList::~NumberList() {
    
    ListNode *p = head;
    ListNode *n;
    while (p!=NULL) {
        n = p->next;  //save address of next node
        delete p;
        p = n;     //make p point to the next node
    }
}

void NumberList::appendNode (double x) {
    append(x, head);
}

void NumberList::append (double x, ListNode *& p) {
    
    if (p == NULL) {
        p = new ListNode;
        p->value = x;
        p->next = NULL;
    }
    else
        append (x, p->next);
}

void NumberList::displayList() {
    
    ListNode *p = head;
    while (p!=NULL) {
        cout << p->value  << "  ";
        p = p->next;
    }
    cout << endl;
    
}

int NumberList::rsearch(double x) 
{ 
       ListNode *current = head;
     int found = 0;
      int i = 0;
      if(current != NULL) {
          
    while (current != NULL) 
    { 
        i++;
        
        if (current->value == x) 
        {
            found++;
            break;
        }
        current = current->next; 
    } 
    if(found == 1){
        return i;
    }
    }
    return -1;
}

int main() {
    
    // set up the list
    NumberList list;
    
    //Append Some values to the list
    list.appendNode(2.5);
    list.appendNode(7.9);
    list.appendNode(12.6);
    
    
    // Display the values in the list
    list.displayList();
    
   cout<< list.rsearch(2.5) << endl;
    
        
    
}

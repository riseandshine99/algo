package leetcode.interviews.microsoft;

public class LinkedList {
    int size=0;
    private  Node head=null;



    public static void main(String[] args){
        LinkedList list=new LinkedList();
        for(int i=1;i<15;i++) list.insert(i);
        list.display();
        list.reverseinKgroups(5);
        list.display();
    }

    public void reverseinKgroups(int k){
        this.head=reverseinKgroupsUtil(this.head,k,size);
    }
    public Node reverseinKgroupsUtil(Node startNode,int k,int sizeRemaining){
        if(sizeRemaining<k) return startNode;
        Node current,prev,next,prevTail,newHead=null;
        Node temp=startNode;
        current=temp;
        prev=null;
        int nodesReversed=0;


            while(nodesReversed<k){
                next=current.next;
                current.next=prev;
                prev=current;
                current=next;
                nodesReversed++;

            }
        Node nextHead=reverseinKgroupsUtil(current,k,sizeRemaining-k);
            startNode.next=nextHead;
            return prev;
    }




    public void reverse(){
        Node prev,current,next;
        prev=null;
        current=head;
        while(current!=null){
            next=current.next;
            current.next=prev;

            prev=current;
            current=next;
        }
        head=prev;
    }
    public int display(){
        Node temp=head;
        System.out.println();
        int n=0;
        while(temp!=null){
            System.out.print(" "+temp.data+" ,");
            temp=temp.next;
            n++;
        }
        return n;
    }
    public void insert(int data){
        Node newNode=new Node(data);
        if(head==null)
             head=newNode;
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public static class Node{
        int data;
        Node next=null;
        public Node(int data){this.data=data;

        }
    }
}

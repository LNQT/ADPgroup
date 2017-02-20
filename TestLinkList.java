package a;

import java.util.Scanner;
public class TestLinkList {
class Node{
	private int data;
	private Node next;
	Node(int x){
		data = x;
		next = null;
	}
	Node(int x, Node p){
		data = x;
		next = p;
	}
	public String toString(){
		return data + "-->";
	}
}
private Node head;
public void taoDanhSach(){
	head= new Node(1,new Node(2,new Node(3,new Node(4,new Node(6,new  Node(7,new Node(8,null)))))));
}
public void xuatDanhSach(){
	Node q=head;
	while(q!=null){
		System.out.print(q);
		q=q.next;
	}
}
public int sumAllElement(){
	int sum=0;
	for(Node i=head;i!=null;i=i.next){
		sum+=i.data;
	}
	return sum;
}
public int productEven(){
	int tich=1;
	for(Node i=head;i!=null;i=i.next){
		if(i.data%2==0)
			tich*=i.data;
	}
	return tich;
}
public int countOdd(){
	int dem=0;
	Node q=head;
	while(q!=null){
		if(q.data%2!=0)
			dem++;
		q=q.next;
	}
	return dem;
}
public boolean isPrime(int x){
	if(x<2)
		return false;
	for(int i=2;i<x/2;i++)
		if(x%i==0)
			return false;
		return true;
}
public double average(){
	double t=0;
	double dem=0;
	Node q=head;
	while(q!=null){
		if(isPrime(q.data)==true){
			t=t+q.data;
			dem++;}
		q=q.next;
	}
	return 1.0*t/dem;
}
public int maxLT(){
	Node q=head;
	int max=q.data+q.next.data;
	while(q.next!=null){
		if(max<q.data+q.next.data){
			max=q.data+q.next.data;}
		q=q.next;
	}return max;
}
public int max(){
	Node q=head;
	int max=q.data+q.next.data;;
	for(Node i=head;i!=null;i=i.next){
		for(Node j=i.next;j!=null;j=j.next){
			if((i.data+j.data)>max)
				max=i.data+j.data;
		}
}
	return max;
}
public boolean searchX(int x){
	Node q=head;
	while(q!=null){
		if(q.data==x){
			return true;
		}
		q=q.next;
	}return false;
}
public boolean sort(){
	for(Node q=head;q!=null;q=q.next)
		if(q.data < q.next.data)
			return false;
	return true;
}
public void reverse(){
	Node q= null;
	while(head!=null){
		Node p=head;
		head=p.next;
		p.next=q;
		q=p;
	}
	head=q;
}
public void insertX(int x, Node p){
	Node q = new Node(x,p);
	if(head== p)head =q;
	else{
		Node r=head;
		while(r.next!=p)r=r.next;
		r.next=q;
	}
}
public void delete(Node p){
	if(p==head) head=head.next;
	else{
		Node r=head;
		while(r.next!=p)
			r=r.next;
			r.next=p.next;
	}
}
public void deleteNegative(){
	for(Node i=head;i!=null;i=i.next){
		if((i.data)<0)
			delete(i);		
	}
}
public void deleteSimullar(){
	for(Node i=head;i!=null;i=i.next){
		for(Node j=i.next;j!=null;j=j.next)
			if(i.data==j.data){
			delete(j);	
			}		
	}
}
public int differenceMinMax(){
	Node q=head;
	int min=q.data;
	int max=q.data;
	for(Node i=head;i!=null;i=i.next){
		if(max<i.data)
			max=i.data;
	}
	for(Node i=head;i!=null;i=i.next){
		if(min>i.data)
			min=i.data;
	}
	return max-min;
}
public void multiply2AllElement(){
	for(Node i=head;i!=null;i=i.next){
		i.data=i.data*2;
	}
}
public void deleteX(int x){
for(Node i=head;i!=null;i=i.next){
	if(i.data==x)
		delete(i);
	else
		System.out.print("Ko co gia tri nao bang so nhap vao");
}
}
public void insertIncrease(int x){
	if(sort()==false){
	for(Node i=head;i!=null;i=i.next){
		Node q=null;
			if(x>i.data && x<i.next.data)// do m nhap vo 9.mak chuoi `1-8 .m nhap 9 la qua cai 
				insertX(x,i.next);
		}
	}
	else
		System.out.println("Danh sach chua duoc sap xep");
}
public static void main(String[] args) {
		TestLinkList b= new TestLinkList();
		b.taoDanhSach();
		b.xuatDanhSach();
		/*//1
		System.out.println("Tong:"+ b.sumAllElement());
		//2
		System.out.println("Tich cac so chan:"+ b.sumAllElement());
		//3
		System.out.println("co "+b.countOdd()+" so le");
		//4
		System.out.println("Trung binh cong:"+ b.average());
		//5
		System.out.println("tong 2 so lien ke lon nhat la "+b.maxLT());
		//6
		System.out.println("tong 2 so  lon nhat trong LinkList la "+b.max());
		//7
		int x;
		System.out.println("Nhap so can tim: ");
		Scanner kb=new Scanner(System.in);
		x=kb.nextInt();
		if(b.searchX(x)==true)
			System.out.println("Co so"+x+"trong LinkList");
		else System.out.println(" ko Co trong LinkList ");
		//8
		if(b.sort()==true)
			System.out.println(" link List is sorted in decending ");
		else 
			System.out.println(" link List is not sorted in decending ");
		//9
		System.out.println("Day so sau khi duoc dao nguoc la: ");
		b.reverse();
		b.xuatDanhSach();
		System.out.println();
		System.out.println("Day so sau khi chen  la: ");
		b.insertX(100, b.head);
		b.insertX(1000, null);
		b.xuatDanhSach();
		System.out.println();
		System.out.println("Day so sau khi xoa la: ");
		b.delete(b.head.next.next);
		b.xuatDanhSach();
		System.out.println();
		//10
		System.out.println("Day so sau khi xoa am la: ");
		b.deleteNegative();
		b.xuatDanhSach();
		System.out.println();
		//11
		System.out.println("Day so sau khi xoa giong nhau la: ");
		b.deleteSimullar();
		b.xuatDanhSach();
		System.out.println();
		//12
		System.out.println("Day so sau khi xoa X la: ");
		b.deleteX(x);
		b.xuatDanhSach();
		System.out.println();*/
		//13
		System.out.println("Danh sach sau khi chen X la: ");
		b.insertIncrease(5 	);
		b.xuatDanhSach();
		System.out.println();
		//14
		//System.out.println("Danh Sach moi sau khi nhan 2 la : ");
		//b.multiply2AllElement();
		//b.xuatDanhSach();
		//15
		//System.out.println("Min-Max: "+b.differenceMinMax());
	//	System.out.println();
		
		
		
	}
}

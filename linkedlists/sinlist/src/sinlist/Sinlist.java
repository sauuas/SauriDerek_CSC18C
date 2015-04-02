/*
 * single linked list
 * Derek Sauri
 */
package sinlist;

/**
 *
 * @author derek
 * @param <T>
 */
public class Sinlist<T> {

      public T data;
    public Sinlist next;
    
    public Sinlist(T data){
        this.data = data;
    }
    public static void main(String[] args) {
        LinkedList theList = new LinkedList();
        
        //check if empty
        theList.isEmpty();
        // push some data
        theList.push('B');
        theList.push(20);
        theList.push(100.25);
        theList.push("cool");
        
        theList.display();
        //pop first value
        System.out.println("popped off stack: "+theList.pop().data);
        //peek at value
        theList.peek();
        //clip end
         System.out.println("clipped off stack: "+theList.clip().data);
        //add to bottom
         theList.add('P');
        //insert before
        System.out.println("show insert before");
        theList.insertBef("before",20);
        theList.display();
        //insert after
        System.out.println("show insert after");
        theList.insertAft("after",20);
        theList.display();
        //remove
        System.out.println("removed "+theList.remove(20).data+" from stack");
        //empty list
        theList.isEmpty();
        theList.clear();
        theList.isEmpty();
        
    }
    
}
class LinkedList<T>{
    public Sinlist firstLink;
    
    LinkedList(){
        firstLink = null;
    }
    // checks if list is empty
    public void isEmpty(){
        if(firstLink == null){
            System.out.println("the stack is empty now");
        }
        else{
            System.out.println("the stack is not empty");
        }
    }
    //displays whole linked list
    public void display(){
        Sinlist theLink = firstLink;
        
        System.out.println("display list");
        while(theLink != null){
            System.out.println("link: "+theLink.data);
            theLink = theLink.next;
            System.out.println();
        }
    }
    //pushes new value to top
    public void push(T data){
        Sinlist newLink = new Sinlist(data);
        System.out.println("push: "+newLink.data);
        newLink.next = firstLink;
        firstLink = newLink;
    }
    //pushes new value to bottom
    public void add(T data){
        Sinlist newLink = new Sinlist(data);
        Sinlist theLink = firstLink;
        while(theLink.next != null) theLink = theLink.next;
        System.out.println("add: "+newLink.data);
        theLink.next = newLink;
    }
    //removes top value
    public Sinlist pop(){
        Sinlist linkRec = firstLink;
        if(firstLink != null){
            firstLink = firstLink.next;
        }
        else{
            System.out.println("stack is empty");
        }
        return linkRec;
    }
    //clips bottom
    public Sinlist clip(){
        Sinlist linkRec = firstLink;
        Sinlist lastLink = firstLink;
        if(firstLink != null){
        do{ lastLink = linkRec;
            linkRec = linkRec.next;
          }while(linkRec.next != null);
        lastLink.next = null;
        }
        else{
            System.out.println("stack is empty");
        }
        return linkRec;
    }
    //looks at, but does not remove data
    public void peek(){
        System.out.println("top of stack "+firstLink.data);
        System.out.println();
    }
    // resets list
    public void clear(){
        firstLink = null;
    }
    //removes specific item from list
    public Sinlist remove(T data){
       Sinlist currentLink = firstLink;
       Sinlist previousLink = firstLink;
       
       while(currentLink.data != data){
           if(currentLink.next == null){
               return null;
           }
           else{
               previousLink = currentLink;
               currentLink = currentLink.next;
           }
       }
       if(currentLink == firstLink){
           firstLink = firstLink.next;
       }
       else{
       System.out.println("current link: "+currentLink.data);
       previousLink.next = currentLink.next;
       }
       return currentLink;
    }
    //insert new data before certain value
    public void insertBef(T data, T value){
        Sinlist newLink = new Sinlist(data);
         Sinlist currentLink = firstLink;
       Sinlist previousLink = firstLink;
       
        while(currentLink.data != value){
           if(currentLink.next == null){
               return;
           }
           else{
               previousLink = currentLink;
               currentLink = currentLink.next;
           }
       }
        if(currentLink == firstLink){
        newLink.next = firstLink;
        firstLink = newLink;
        }
        else{
            previousLink.next = newLink;
            newLink.next = currentLink;
        }
    }
    //insert new data after certain value
    public void insertAft(T data,T value){
        Sinlist newLink = new Sinlist(data);
         Sinlist currentLink = firstLink;
       
        while(currentLink.data != value){
           if(currentLink.next == null){
               return;
           }
           else{
               currentLink = currentLink.next;
           }
       }
        newLink.next = currentLink.next;
        currentLink.next = newLink;
    }
    
}

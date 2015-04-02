/**
 * Derek Sauri
 * double linked list
 */
package prique;

/**
 *
 * @author derek
 * @param <T>
 */
public class PriQue<T> {
   public T data;
   public int pri;  //judge priority level
 public PriQue next;
 public PriQue back;
    
 public PriQue(T data, int pri){
        this.data = data;
        this.pri = pri;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList theList = new LinkedList();
        
        // push some data
        theList.push('B', 1);
        theList.push(20, 4);
        theList.push(100.25, 3);
        theList.push(10, 2);
        theList.display();
        //pop first value
        System.out.println("popped off stack: "+theList.pop().data);
        //peek at value
        theList.peek();
        //insert before
        //add to bottom of list
        System.out.println("add to bottom of stack");
        theList.add(21, 2);
        theList.display();
        //"peek" at bottom of stack
        System.out.println("gander at bottom of stack");
        theList.gander();
        //"pop" the bottom of the stack
         System.out.println("clipped off stack: "+theList.clip().data);
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
    public PriQue head;
    public PriQue tail;
    
    LinkedList(){
   head = null;
   tail = null;
    }
    // checks if list is empty
    public void isEmpty(){
        if(head == null){
            System.out.println("the stack is empty now");
        }
        else{
            System.out.println("the stack is not empty");
        }
    }
    //displays whole linked list
    public void display(){
        PriQue theLink = head;
        
        System.out.println("display list");
        while(theLink != null){
            System.out.println("link: "+theLink.data);
            theLink = theLink.next;
            System.out.println();
        }
    }
    //pushes new value to top
    public void push(T data, int pri){
        PriQue newLink = new PriQue(data, pri);
        PriQue theLink = head;
        PriQue lastLink = head;
        System.out.println("push: "+newLink.data);
        if(head != null){
            while(newLink.pri > theLink.pri){
                if(theLink.next == null)break;
                lastLink = theLink;
                theLink = theLink.next;
            }
            if(theLink == head){
                newLink.next = head;
                head.back = newLink;
                head = newLink;
            }
            else{
                lastLink.next = newLink;
                newLink.back = lastLink;
                newLink.next = theLink;
                theLink.back = newLink;
            }
        }
        else{
            newLink.next = head;
             head = newLink;
              tail = head;
        }
    }
    //adds new value to bottom
    public void add(T data, int pri){
        PriQue newLink = new PriQue(data, pri);
        PriQue theLink = tail;
        PriQue lastLink = tail;
        System.out.println("add: "+newLink.data);
        if(tail != null){
             while(newLink.pri < theLink.pri){
                if(theLink.back == null)break;
                lastLink = theLink;
                theLink = theLink.back;
            }
             if(theLink == tail){
                newLink.back = tail;
                tail.next = newLink;
                tail = newLink;
            }
             else{
                lastLink.back = newLink;
                newLink.next = lastLink;
                newLink.back = theLink;
                theLink.next = newLink;
             }
        }
        else{
           newLink.back = tail;
           tail = newLink;
           head = tail;
        }
    }
    //removes top value
    public PriQue pop(){
        PriQue linkRec = head;
        if(head != null){
            head = head.next;
        }
        else{
            System.out.println("stack is empty");
        }
        return linkRec;
    }
    //removes bottom value
    public PriQue clip(){
        PriQue linkRec = tail;
        if(tail != null){
            tail = tail.back;
            tail.next = null;
        }
        else{
            System.out.println("stack is empty");
        }
        return linkRec;
    }
    //looks at, but does not remove top data
    public void peek(){
        System.out.println("top of stack "+head.data);
        System.out.println();
    }
    //looks at, but does not remove bottom data
    public void gander(){
         System.out.println("bottom of stack "+tail.data);
        System.out.println();
    }
    // resets list
    public void clear(){
      head = null;
      tail = null;
    }
    //removes specific item from list
    public PriQue remove(T data){
       PriQue currentLink = head;
       PriQue previousLink = head;
       PriQue nextLink = head;
       
       //search for data
       while(currentLink.data != data){
           if(currentLink.next == null){
               System.out.println("data not found.");
               return null;
           }
           else{
               previousLink = currentLink;
               currentLink = currentLink.next;
               nextLink = currentLink.next;
           }
       }
       //deal with link that has data
       if(currentLink == head){
           System.out.println("First link: "+currentLink.data);
           head = head.next;
       }
       else{
       System.out.println("link to be removed: "+currentLink.data);
       nextLink.back = currentLink.back;
       previousLink.next = currentLink.next;
       }
       return currentLink;
    }
}

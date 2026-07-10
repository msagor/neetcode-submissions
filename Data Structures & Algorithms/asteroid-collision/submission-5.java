class Solution {
    //the description of this problem is hard to understand -  
    //One commenter said - 
      //There is a trick, Two asteroids moving in the different direction will also have possibilities that never meet, 
      //if the first one is '-' and second one is '+', so the first one will go to the left but second one will go to right! so never meet.
    //Another said - 
      //There is an unwritten assumption in the question that the relative position in the array is the position left or right. 
      //So [-2, 2] won't collide because they are moving away from each other, while [2, -2] would.
    
    //took a long time to implement mysel=, maybe not the best code, but i did implement this myself.
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<Integer>();

        for(int a: asteroids){
            
            if(!stack.isEmpty()){
                
                //peek the top element
                int top = stack.peek();

                //first check direction
                if( (top > 0 && a>0 ) || (top < 0 && a<0) ){
                    //both asteroids going same directions
                    stack.push(a);
                }else if(top<0 && a>0){
                    //both asteroids going oppopsite directions away from each other
                    stack.push(a);
                }else{
                    //One or more collisions will take place
                    //there are few cases
                      //both going same direction
                      //both gets destroyed
                      //top destroys currVal
                      //currVal destroys top, in this case we keep looping
                    
                    int currVal = a;
                    while(!stack.isEmpty()){

                        int t = stack.pop();

                        if(t<0 && currVal<0){
                            //both going the same direction so no collision
                            //push the values back and break the loop
                            stack.push(t);
                            stack.push(currVal);
                            break;
                        }else if(t + currVal == 0){
                            //both gets destroyed
                            break;
                        }else if( Math.abs(t) > Math.abs(currVal) ){
                            //the value that was already in the stack is winner
                            // so we put it back and break the loop
                            stack.push(t);
                            break;
                        }else{
                            //the new asteroid value is the winner
                            //so we discad the top value t

                            //if the stack is currently empty then currVal goes in stack and we break the loop
                            if(stack.isEmpty()){
                                stack.push(currVal);
                                break;
                            }

                        }
                    }
                }
            }else{
                //stack is empty so we put the first item
                stack.push(a);
            }
        }

        int[] array = stack.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }
}

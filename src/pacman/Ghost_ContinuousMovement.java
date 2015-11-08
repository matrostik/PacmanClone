package pacman;

class Ghost_ContinuousMovement implements Runnable, constants
{
    public Ghost_ContinuousMovement() {
        Thread cont = null;
        cont = new Thread(this);
        cont.start();
    }
    
    
    public void run() {
        while(true) {
                 if ( !Movement.g1_eat ) {    Ghost_Movement_1 ghost1_mv = new Ghost_Movement_1() ; }     // an exei fagw8ei prepei na perimenei th lhksh tou booster gia na emfanistei pali
                 if ( !Movement.g2_eat ) {    Ghost_Movement_2 ghost2_mv = new Ghost_Movement_2() ; } 
                 if ( !Movement.g3_eat ) {    Ghost_Movement_3 ghost3_mv = new Ghost_Movement_3() ; } 
                 if ( !Movement.g4_eat ) {    Ghost_Movement_4 ghost4_mv = new Ghost_Movement_4() ; } 
                 try { Thread.sleep(500);} catch (InterruptedException ie) {}
        } 
    }
}
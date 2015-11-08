package pacman;

class countBoostime extends counter implements Runnable
{
    static byte timesCalled = 0; 
    byte myCall;                 
    public countBoostime()
    {
        super(1);  
        Thread thread = null;
        thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        timesCalled++;
        myCall = timesCalled;
        try {
            Thread.sleep(7000);
        } catch (InterruptedException ie) {}
        
        if(myCall == timesCalled) {       
            Movement.boosterActive = false;   
            timesCalled = 0;                  
            Movement.g1_eat = false ; Movement.g2_eat = false ; Movement.g3_eat = false ; Movement.g4_eat = false ;
            
        }
    }
}


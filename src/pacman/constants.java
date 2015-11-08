package pacman;

interface constants
{
    static final short init_lives = 3;  
    static final char space = ' ';
    static final char food = '.';
    static final char booster = 'O';
    
    static final char ghost1 = 'F';
    static final char ghost2 = 'G';
    static final char ghost3 = 'H';
    static final char ghost4 = 'J';

    static final char PacmanPos = 'P';
    static final char wall = '#';
    static final char fantomExit = '-';
    static final char fruit = 'f';
    
    static final short north = 0;
    static final short south = 1;
    static final short west = 2;
    static final short east = 3;
    
    // Η ταχύτητα του Pacman einai antistrofh se sxesh me thn kauhsterhsh pou kanei gia na alla3ei 8esh dhladh otan megalonei h taxuthta mikrainei to delay...
    static final int slowSpeed = 12;  // argh taxuthta => delay megalo
    static final int fastSpeed = slowSpeed - (int)(slowSpeed * 0.3);  // grugorh taxuthta => mikrotero to delay kata 30% ths arghs
    static int slowSpeed_BoosterActive = slowSpeed - (int)(slowSpeed * 0.2);  // argh taxutita me energopoihmeno Booster => mikrotero delay kata 20% ths arghs
    static int fastSpeed_BoosterActive = fastSpeed - (int)(fastSpeed * 0.2); // grugorh taxuthta me energopoihmeno booster => mikrotero delay kata 20% ths grugorhs (h megaluterh taxuthta tou PacMacn!)
    
    // speed gia to ghost1
    static final int slowSpeed1 = 13;
    static final int slowSpeed1_BoosterActive = slowSpeed1 - (int)(slowSpeed1 * 0.1);
    static final int fastSpeed1 = slowSpeed1 - (int)(slowSpeed1 * 0.3);
    static final int fastSpeed1_BoosterActive = fastSpeed1 - (int)(fastSpeed1 * 0.1);
    
    // speed gia to ghost2
    static final int slowSpeed2 = 12;
    static final int slowSpeed2_BoosterActive = slowSpeed2 - (int)(slowSpeed2 * 0.1);
    static final int fastSpeed2 = slowSpeed2 - (int)(slowSpeed2 * 0.3);
    static final int fastSpeed2_BoosterActive = fastSpeed2 - (int)(fastSpeed2 * 0.1);
    
    // speed gia to ghost3
    static final int slowSpeed3 = 11;
    static final int slowSpeed3_BoosterActive = slowSpeed3 - (int)(slowSpeed3 * 0.1);
    static final int fastSpeed3 = slowSpeed3 - (int)(slowSpeed3 * 0.3);
    static final int fastSpeed3_BoosterActive = fastSpeed3 - (int)(fastSpeed3 * 0.1);
    
    // speed gia to ghost4
    static final int slowSpeed4 = 10;
    static final int slowSpeed4_BoosterActive = slowSpeed4 - (int)(slowSpeed4 * 0.1);
    static final int fastSpeed4 = slowSpeed4 - (int)(slowSpeed4 * 0.3);
    static final int fastSpeed4_BoosterActive = fastSpeed4 - (int)(fastSpeed4 * 0.1);
    
    // H au3hsh tou score analogws me to ti 8a faei o Pacman
    final short upcookie = 10;  // h au3hsh tou score otan trogetai ena cookie
    final short upbooster = 50; // h au3hsh tou score otan fago8ei ena booster
    final short upfruit = 600 ;  // h aukshsh tou score otan fagw8ei ena fruit
    final int upFirstGhost = 200;   // h au3hsh tou score otan fago8ei to prwto fantasmataki
    final int upSecondGhost = 400;
    final int upThirdGhost = 800;
    final int upForthGhost = 1600;
    /* 8a mporousame na eixame xrhsimopoihsei kateu8eian to teleutaio statement tou if else if... block gia to ypologismo tou score pou kerdizetai otan
     * o Pacman trwei ena fantasma alla afou mas dinontai rhta oi times gia thn au3hsh tou score protimhsame na to afhsoume etsi
     */
    
    // an to score f8asei thn ka8orismenh timh tote au3anotai o ari8mos twn ζωών του. Εδώ είναι που καταργείται το λαϊκό άσμα μια ζωή την έχουμε...
    final short scoreupLive = 3000;
    
    static final int posPixel = 24; // ka8e 8esh sto Pinaka tou Pacman se posa pixel anaparistatai
}
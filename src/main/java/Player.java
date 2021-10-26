public class Player {
    private double fielding;
    private int errors;
    private int attempts;
    private double average;
    private double slugging;
    private int atBats;
    private int singles;
    private int doubles;
    private int triples;
    private int homers;
    private int hits;
    public Player(int ab, int s, int d, int t, int h, int e, int att){
        this.atBats=ab;
        this.singles=s;
        this.doubles=d;
        this.triples=t;
        this.homers=h;
        this.errors=e;
        this.attempts=att;
        this.hits=this.singles+this.doubles+this.triples+this.homers;
    }
    public void atBat(){
        this.atBats++;
        if (Math.random()<=this.average){
            getHitResult();
            this.hits++;
        }
    }
    public void getHitResult(){
        if (Math.random()<=((double)this.singles/this.hits)){
            this.singles++;
        }
        else if (Math.random()<=((double)this.doubles/this.hits)){
            this.doubles++;
        }
        else if (Math.random()<=((double) this.homers/this.hits)){
            this.homers++;
        }
        else if (Math.random()<=((double) this.triples/this.hits)){
            this.triples++;
        }
        else{
            this.singles++;
        }
    }
    public void updateAverage(){
        this.average=((double)this.hits/this.atBats);
    }
    public void updateSlugging(){
        int slugHits= (4*this.homers)+(3*this.triples)+(2*this.doubles)+this.singles;
        this.slugging=((double)slugHits/this.atBats);
    }
    public void simAttempt(){
        this.attempts++;
        if (Math.random()>this.fielding){
            this.errors++;
        }
    }
    public void updateFielding(){
        this.fielding=(double) (this.attempts-this.errors)/this.attempts;
    }
    public void simGame(){
        for (int i=0;i<4;i++){
            atBat();
        }
        for (int i=0;i<6;i++){
            simAttempt();
        }
    }
    public void simSeason(){
        for (int i=0;i<162;i++){
            simGame();
        }
    }
    public String checkStats(){
        int slugging = (int) (this.slugging*1000);
        int average = (int) (this.average*1000);
        int fielding = (int) (this.fielding*1000);
        String hit = "."+average+ " AVG/ ." + slugging + " SLG/ " + this.homers + " HR/ " + this.triples + " 3B/ " + this.doubles + " 2B/ " + this.singles + " 1B/ " + this.atBats + " AB/ .";
        String field = fielding + " FLD/ " + this.errors + " ERR " + this.attempts + " ATT";
        return "Your career stats are " +hit+field;
    }
    public void update(){
        updateAverage();
        updateFielding();
        updateSlugging();
    }


}

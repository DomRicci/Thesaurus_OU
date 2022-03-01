import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Write a description of class thesaurus here.
 *
 * @author (Dom RIcci)
 * @version (04-02-2022)
 */
public class Thesaurus
{
    // instance variables
    private HashMap<String, HashSet<String>> synonyms;

    /**
     * Constructor for objects of class thesaurus
     */
    public Thesaurus()
    {
       synonyms = new HashMap<String, HashSet<String>>();
    }

    /**
     * to return synonyms for testing purposes
     * @return synonyms
     */
    public HashMap<String, HashSet<String>> getThesaurus()
    {
        return synonyms;
    }

    /**
     * for testing purposes, populates synonyms with two sample key values.
     * happy - joyful contented cheerful
     * angry - annoyed vexed
     */
    public void populate()
    {
        HashSet<String> happySet=new HashSet<String>(Arrays.asList("joyful", "contented", "cheerful"));
        synonyms.put("happy", happySet);
        HashSet<String> angrySet= new HashSet<String>(Arrays.asList("annoyed", "vexed"));
        synonyms.put("angry", angrySet);
    }
    /**
     * prints out all the keys and their synonyms
     */
    public void print(){
        for (String keys : synonyms.keySet())
        {
            System.out.println(keys +" : " + synonyms.get(keys));
        }
    }
    /**
     * allows the user to enter a word and a synonym for said word.
     * this is then added to the hashmap synonyms. if the word already in synonyms
     * then asynonym is added to that hashset. if not a new entry is created with aWord as key and aSynonym as value.
     *
     * 
     * @param aWord 
     * @param aSynonym
     */
    public void addSynonym(String aWord, String aSynonym){
        java.util.Iterator<String> it = synonyms.keySet().iterator();
        while(it.hasNext())
        {
            String wordy = it.next();
            if (aWord.equals(wordy))
            {
                HashSet<String> newSet = new HashSet<String>(synonyms.get(wordy));
                newSet.add(aSynonym);
                synonyms.replace(wordy, newSet);
                return;
            }
        }
        HashSet<String> newSet = new HashSet<String>();
        newSet.add(aSynonym);
        synonyms.put(aWord, newSet);
        return;
    }

    /**
     * this prints new variations of the aSentence. using different synonyms for aWord.
     * @param aSentence
     * @param aWord
     */

    public void replaceWord(String aWord, String aSentence)
    {
        HashSet<String> theWords = new HashSet<String>(synonyms.get(aWord));
        for (String strings : theWords) {
            String newSentence = aSentence.replace(aWord, strings);
            System.out.println(newSentence);
        }

    }
    /**
     * method that causes each synonym to be cross-referenced in the thesaurus. resulting
     * in each value having its own key so all synonyms can be easily accessed.
     * 
     */
    public void crossReference()
    {
        //java.util.Iterator<String> it = synonyms.keySet().iterator();
        HashSet<String> it = new HashSet<String>(synonyms.keySet());
        for (String wordy : it){
            //String wordy = it.next();
            HashSet<String> values = new HashSet<String>(synonyms.get(wordy));
            for (String value : values){
                HashSet<String> newSet = new HashSet<String>(values);
                newSet.remove(value);
                newSet.add(wordy);
                synonyms.put(value, newSet);
            }
            
        }
        
    }
}
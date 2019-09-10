package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCheck = (Button) findViewById(R.id.buttonCheck);
        Button buttonNext = (Button) findViewById(R.id.buttonNxt);
        Button buttonHis = (Button) findViewById(R.id.buttonHis);
        TextView total = (TextView) findViewById(R.id.total);
        TextView correct = (TextView) findViewById(R.id.correct);
        //this is the global variable word list, consisting of all terms and their definitions. They cannot be changed by inner class methods
        final wordBank git = new wordBank();
        git.addTerm(new terms("blame","A feature in Git describes the last modification to each line of a file, which generally displays the revision, author and time. This is helpful, for example, in tracking down when a feature was added, or which commit led to a particular bug."),0);
        git.addTerm(new terms("branch","A parallel version of a repository. It is contained within the repository, but does not affect the primary or master branch allowing you to work freely without disrupting the \"live\" version. When you've made the changes you want to make, you can merge your branch back into the master branch to publish your changes."),1);
        git.addTerm(new terms("clone", "A copy of a repository that lives on your computer instead of on a website's server somewhere, or the act of making that copy. With your clone you can edit the files in your preferred editor and use Git to keep track of your changes without having to be online. It is, however, connected to the remote version so that changes can be synced between the two. You can push your local changes to the remote to keep them synced when you're online."),2);
        git.addTerm(new terms("collaborator","A person with read and write access to a repository who has been invited to contribute by the repository owner."),3);
        git.addTerm(new terms("commit", "A \"revision\", or an individual change to a file (or set of files). It's like when you save a file, except with Git, every time you save it creates a unique ID (a.k.a. the \"SHA\" or \"hash\") that allows you to keep record of what changes were made when and by who. Commits usually contain a commit message which is a brief description of what changes were made."),4);
        git.addTerm(new terms("diff","The difference in changes between two commits, or saved changes. The diff will visually describe what was added or removed from a file since its last commit."),5);
        git.addTerm(new terms("fetch","It refers to getting the latest changes from an online repository without merging them in. Once these changes are fetched you can compare them to your local branches (the code residing on your local machine)."),6);
        git.addTerm(new terms("fork","A personal copy of another user's repository that lives on your account. Forks allow you to freely make changes to a project without affecting the original. Forks remain attached to the original, allowing you to submit a pull request to the original's author to update with your changes. You can also keep your fork up to date by pulling in updates from the original."),7);
        git.addTerm(new terms("issue", "Suggested improvements, tasks or questions related to the repository. Issues can be created by anyone (for public repositories), and are moderated by repository collaborators. Each issue contains its own discussion forum, can be labeled and assigned to a user."),8);
        git.addTerm(new terms("merge","Taking the changes from one branch (in the same repository or from a fork), and applies them into another. This often happens as a pull request (which can be thought of as a request to merge), or via the command line. A merge can be done automatically via a pull request via the GitHub web interface if there are no conflicting changes, or can always be done via the command line."),9);
        git.addTerm(new terms("private repository","Repositories that can only be viewed or contributed to by their creator and collaborators the creator specified."),10);
        git.addTerm(new terms("pull","When you are fetching in changes and merging them. For instance, if someone has edited the remote file you're both working on, you'll want to pull in those changes to your local copy so that it's up to date."),11);
        git.addTerm(new terms("pull request", "A proposed change to a repository submitted by a user and accepted or rejected by a repository's collaborators."),12);
        git.addTerm(new terms("push", "Sending your committed changes to a remote repository, such as a repository hosted on GitHub. For instance, if you change something locally, you'd want to then push those changes so that others may access them."),13);
        git.addTerm(new terms("repository","The most basic element of GitHub. They're easiest to imagine as a project's folder. A repository contains all of the project files (including documentation), and stores each file's revision history. Repositories can have multiple collaborators and can be either public or private"),14);






        buttonCheck.setOnClickListener(new View.OnClickListener(){


            public void onClick(View view) {
                int tot = 0;
                int cor = 0;
                TextView definition = (TextView) findViewById(R.id.definition);
                TextView feedback = (TextView) findViewById(R.id.feedback);
                EditText answer = (EditText) findViewById(R.id.answer);
                TextView total = (TextView) findViewById(R.id.total);
                TextView correct = (TextView) findViewById(R.id.correct);
                if(answer.getText().toString().equals(git.matchWord(definition.getText().toString()))){
                    feedback.setText("Bingo!!!");
                    /*int k =git.findIndex(definition.getText().toString());
                    terms t = git.getTerm(k);
                    t.visit();
                    git.removeTerm(k);
                    git.addTerm(t,k);*/

                    tot++;
                    cor++;


            }
                else{
                    feedback.setText("Oops...The correct answer is: " + git.matchWord(definition.getText().toString())+".");
                    /*int k =git.findIndex(definition.getText().toString());
                    terms t = git.getTerm(k);
                    t.visit();
                    t.wrong();
                    git.removeTerm(k);
                    git.addTerm(t,k);*/
                    tot++;

                }

                total.setText(""+tot);
                correct.setText(""+cor);

        }});
        buttonNext.setOnClickListener((new View.OnClickListener(){
            @Override

            public void onClick(View view) {
            TextView definition = (TextView) findViewById(R.id.definition);
            TextView feedback = (TextView) findViewById(R.id.feedback);
            EditText answer = (EditText) findViewById(R.id.answer);

                if(definition.getText().toString().equals(git.getTerm(14).getDefinition())){
                definition.setText(git.getTerm(0).getDefinition());
                answer.setText("");
            }
            else{ int n = git.findIndex(definition.getText().toString())+1;
                definition.setText(git.getTerm(n).getDefinition());
                answer.setText("");
            }
            }
        }));

        buttonHis.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                loadScreen();
            }

        }));









    }

    @Override
    public void onClick(View view) {

    }
    public void loadScreen() {

        Intent intent = new Intent(this,Main2Activity.class);
        TextView total = (TextView) findViewById(R.id.total);
        TextView correct = (TextView) findViewById(R.id.correct);
        if(!total.getText().toString().equals("")&&!correct.getText().toString().equals("")){
        int num =  Integer.parseInt(total.getText().toString());
        int right =  Integer.parseInt(correct.getText().toString());
            intent.putExtra("total_pass",num);
            intent.putExtra("total_right",right);}
        else{
            int num = -1;
            int right = 0;
            intent.putExtra("total_pass",num);
            intent.putExtra("total_right",right);
        }
        startActivity(intent);

    }

}

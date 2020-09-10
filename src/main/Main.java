package main;

import antlr4.js.ECMAScriptLexer;
import antlr4.js.ECMAScriptParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {


    public static void main(String[] args) throws Exception {
        ECMAScriptLexer lexer = new ECMAScriptLexer(CharStreams.fromString("a=10"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ECMAScriptParser parser = new ECMAScriptParser(tokens);
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ECMAWorker(), tree);
    }
}
package com.mutants.app.domain.wrappers;


public abstract class DNASequence {

	private String[] words;

	public DNASequence(String[] words){
		super();
		this.words = words;
	}

	public char base(int row, int col){
		return words[row].charAt(col);
	}

	public String word(int row){
		return words[row];
	}

	/* Methods to implement */

	public abstract int length();

}
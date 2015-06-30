package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum TagType {
	MATERIAL, SIZE, WIDTH(SIZE), HEIGHT(SIZE), DEPTH(SIZE);
	
	private Set<TagType> parents = EnumSet.allOf(TagType.class);
	private Set<TagType> children = Collections.synchronizedSet(EnumSet.allOf(TagType.class));
	
	private TagType() {
		
	}
	private TagType(TagType... parents) {
		this.parents.addAll(Arrays.asList(parents));
		Arrays.stream(parents)
			.forEach(p -> p.children.add(this));
	}

}

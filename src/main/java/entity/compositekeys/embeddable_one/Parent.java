package entity.compositekeys.embeddable_one;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Parent {

	@EmbeddedId
	private ParentPrimaryKey parentPrimaryKey;

	@OneToMany(mappedBy = "parent", cascade = {CascadeType.PERSIST})
	private Set<Child> children = new HashSet<Child>();

	public Parent() {
	}

	public Parent(ParentPrimaryKey parentPrimaryKey) {
		this.parentPrimaryKey = parentPrimaryKey;
	}

	public void addChild(Child child) {
		child.setParent(this);
		this.children.add(child);
	}

	public ParentPrimaryKey getParentPrimaryKey() {
		return parentPrimaryKey;
	}

	public void setParentPrimaryKey(ParentPrimaryKey parentPrimaryKey) {
		this.parentPrimaryKey = parentPrimaryKey;
	}

	public Set<Child> getChildren() {
		return children;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}
}

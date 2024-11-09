package com.kdigital.cookietest1;

import javax.print.attribute.Attribute;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.PageRanges;
import java.util.HashSet;
import java.util.Set;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewTest implements PrintRequestAttributeSet {
    // Attribute를 저장할 Set
    private Set<Attribute> attributes = new HashSet<>();

    @Override
    public Attribute get(Class<?> category) {
        for (Attribute attribute : attributes) {
            if (attribute.getCategory().equals(category)) {
                return attribute;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Class<?> category) {
        return attributes.removeIf(attr -> attr.getCategory().equals(category));
    }

    @Override
    public boolean remove(Attribute attribute) {
        return attributes.remove(attribute);
    }

    @Override
    public boolean containsKey(Class<?> category) {
        return attributes.stream().anyMatch(attr -> attr.getCategory().equals(category));
    }

    @Override
    public boolean containsValue(Attribute attribute) {
        return attributes.contains(attribute);
    }

    @Override
    public int size() {
        return attributes.size();
    }

    @Override
    public Attribute[] toArray() {
        return attributes.toArray(new Attribute[0]);
    }

    @Override
    public void clear() {
        attributes.clear();
    }

    @Override
    public boolean isEmpty() {
        return attributes.isEmpty();
    }

    @Override
    public boolean add(Attribute attribute) {
        return attributes.add(attribute);
    }

    @Override
    public boolean addAll(AttributeSet attributes) {
        boolean changed = false;
        for (Attribute attribute : attributes.toArray()) {
            changed |= add(attribute);
        }
        return changed;
    }
}

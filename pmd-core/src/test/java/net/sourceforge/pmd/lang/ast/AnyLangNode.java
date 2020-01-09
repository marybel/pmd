/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ast;

public class AnyLangNode extends AbstractNode {
    public static final String X_PATH_NAME = "anyLangNode";
    private final boolean findBoundary;
    private final String xpathName;

    public AnyLangNode(int id) {
        this(id, false);
    }

    public AnyLangNode(int id, boolean findBoundary) {
        this(id, findBoundary, X_PATH_NAME);
    }

    public AnyLangNode(int id, boolean findBoundary, String xpathName) {
        super(id);
        this.findBoundary = findBoundary;
        this.xpathName = xpathName;
    }

    @Override
    public String toString() {
        return xpathName;
    }

    @Override
    public String getXPathNodeName() {
        return xpathName;
    }
    
    @Override
    public boolean isFindBoundary() {
        return findBoundary;
    }
}

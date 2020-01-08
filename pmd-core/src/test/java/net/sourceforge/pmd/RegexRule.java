/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd;

import net.sourceforge.pmd.lang.Language;
import net.sourceforge.pmd.lang.LanguageAgnosticModule;
import net.sourceforge.pmd.lang.LanguageRegistry;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.rule.AbstractRule;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sample rule that detect any node with an image of "Foo". Used for testing.
 */
public class RegexRule extends AbstractRule {

    public static final Language LANGUAGE = LanguageRegistry.getLanguage(LanguageAgnosticModule.NAME);
    private Pattern pattern;

    public RegexRule(String patternString) {
        pattern = Pattern.compile(patternString);
        setLanguage(LANGUAGE);
        setName("Foo");
    }

    @Override
    public String getMessage() {
        return "blah";
    }

    @Override
    public String getRuleSetName() {
        return "RuleSet";
    }

    @Override
    public String getDescription() {
        return "desc";
    }

    @Override
    public void apply(List<? extends Node> nodes, RuleContext ctx) {
        for (Node node : nodes) {
            apply(node, ctx);
        }
    }

    protected void apply(Node node, RuleContext ctx) {
        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            apply(node.jjtGetChild(i), ctx);
        }

        Matcher matcher = pattern.matcher(node.getImage());
        if (matcher.matches()) {
            addViolation(ctx, node);
        }
    }
}

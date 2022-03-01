class Article {
    String text;
}

abstract class AbstractCommand {
    Article article;

    AbstractCommand(Article article) {
        this.article = article;
    }

    abstract void executeCommand();
}

class OperationCommand extends AbstractCommand {
    String newText;

    OperationCommand(Article article, String text) {
        super(article);
        this.newText = text;
    }

    @Override
    void executeCommand() {
        article.text = article.text + " - " + this.newText;
    }

}

class Test {
    public static void main(String[] args) {
        Article article = new Article();
        AbstractCommand ac = new OperationCommand(article, "Utkal");
        ac.executeCommand();
        System.out.println(article.text);

    }
}
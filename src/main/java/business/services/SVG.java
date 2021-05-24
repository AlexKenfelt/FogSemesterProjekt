package business.services;

public class SVG
{
    //Making a svg object of the StringBuilder class.
    StringBuilder svg = new StringBuilder();

    //Creating the needed variables.
    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    //Below here we have some Strings that does what?
    private final String headerTemplate = "<svg height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" " +
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String rectTemplate = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";

    private final String frameSideTemplate = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"fill: #ffffff\" />";

    private final String lineTemplate = "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:#000000; fill: #ffffff\" stroke-dasharray=\"5 5\"/>";

    private final String arrowTemplate = "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:#000000; fill: #ffffff; marker-start: url(#beginArrow); marker-end: url(#endArrow)\"/>";

    private final String textTemplate = "<text x=\"%f\" y=\"%f\" fill=\"black\" transform=\"rotate(%f %f,%f)\"> %d cm</text>\n";

    private final String markerOneTemplate = "<defs>\n" +
            "        <marker\n" +
            "                id=\"beginArrow\"\n" +
            "                markerWidth=\"12\"\n" +
            "                markerHeight=\"12\"\n" +
            "                refX=\"0\"\n" +
            "                refY=\"6\"\n" +
            "                orient=\"auto\">\n" +
            "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\"/>\n" +
            "        </marker>\n" +
            "        <marker\n" +
            "                id=\"endArrow\"\n" +
            "                markerWidth=\"12\"\n" +
            "                markerHeight=\"12\"\n" +
            "                refX=\"12\"\n" +
            "                refY=\"6\"\n" +
            "                orient=\"auto\">\n" +
            "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\"/>\n" +
            "        </marker>\n" +
            "    </defs>";

    private final String roofTemplate = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #3A3B3C\" />";

    //Our SVG Constructor.
    public SVG(int x, int y, String viewBox, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
    }

    //What does this method?
    public void addRect(double x, double y, double height, double width)
    {
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    //What does this method?
    public void addSideFrame(double x, double y, double height, double width)
    {
        svg.append(String.format(frameSideTemplate, x, y, height, width));
    }

    //What does this method?
    public void addLine(double x1, double y1, double x2, double y2)
    {
        svg.append(String.format(lineTemplate, x1, y1, x2, y2));
    }

    //What does this method?
    public void addArrow(double x1, double y1, double x2, double y2)
    {
        svg.append(String.format(arrowTemplate, x1, y1, x2, y2) + markerOneTemplate);
    }

    //What does this method?
    public void addRoof(double x, double y, double height, double width)
    {
        svg.append(String.format(roofTemplate, x, y, height, width));
    }

    //What does this method?
    public void addText(double x, double y, double rotation, int length)
    {
        svg.append(String.format(textTemplate, x, y, rotation, x, y, length));
    }

    //What does this method?
    public void addSvg(SVG innerSVG)
    {
        svg.append(innerSVG.toString());
    }

    @Override
    public String toString()
    {
        return svg.toString() + "</svg>";
    }
}
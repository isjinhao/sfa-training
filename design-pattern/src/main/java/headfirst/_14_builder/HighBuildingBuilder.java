package headfirst._14_builder;

public class HighBuildingBuilder extends HouseBuilder {

	@Override
	protected void buildHeight() {
		house.setHeight("100m");
	}

	@Override
	protected void buildColor() {
		house.setColor("白色");
	}

	@Override
	protected void buildLayers() {
		house.setLayers("50层");
	}

}

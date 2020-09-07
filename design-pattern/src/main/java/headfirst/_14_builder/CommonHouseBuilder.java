package headfirst._14_builder;

public class CommonHouseBuilder extends HouseBuilder {

	@Override
	protected void buildHeight() {
		house.setHeight("20m");
	}

	@Override
	protected void buildColor() {
		house.setColor("红色");
	}

	@Override
	protected void buildLayers() {
		house.setLayers("10层");
	}

}

package MangoSupplyChain;

import com.owlike.genson.annotation.JsonProperty;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType()
public final class Mango {

	@Property()
	private final String productId;

	@Property()
	private final String productDescription;

	@Property()
	private final String producerName;

	@Property()
	private final String producerAddress;

	@Property()
	private final String harvestDate;
	
	@Property()
	private final String distributerName;
	
	@Property()
	private final String distributerAddress;
	
	@Property()
	private final String prodToDistDate;
	
	@Property()
	private final String retailerName;
	
	@Property()
	private final String retailerAddress;
	
	@Property()
	private final String distToRetaDate;


	public String getProductId() {
		return productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public String getProducerName() {
		return producerName;
	}

	public String getProducerAddress() {
		return producerAddress;
	}

	public String getHarvestDate() {
		return harvestDate;
	}
	
	public String getDistributerName() {
		return distributerName;
	}
	
	public String getDistributerAddress() {
		return distributerAddress;
	}
	
	public String getProdToDistDate() {
		return prodToDistDate;
	}
	
	public String getRetailerName() {
		return retailerName;
	}
	
	public String getRetailerAddress() {
		return retailerAddress;
	}
	
	public String getDistToRetaDate() {
		return distToRetaDate;
	}

	public Mango(@JsonProperty("productId") final String productId, @JsonProperty("productDescription") final String productDescription,
			@JsonProperty("producerName") final String producerName, @JsonProperty("producerAddress") final String producerAddress,
			@JsonProperty("harvestDate") final String harvestDate, @JsonProperty("distributerName") final String distributerName,
			@JsonProperty("distributerAddress") final String distributerAddress, @JsonProperty("prodToDistDate") final String prodToDistDate, 
			@JsonProperty("retailerName") final String retailerName, @JsonProperty("retailerAddress") final String retailerAddress,
			@JsonProperty("distToRetaDate") final String distToRetaDate) {
		this.productId = productId;
		this.productDescription = productDescription;
		this.producerName = producerName;
		this.producerAddress = producerAddress;
		this.harvestDate = harvestDate;
		this.distributerName = distributerName;
		this.distributerAddress = distributerAddress;
		this.prodToDistDate = prodToDistDate;
		this.retailerName = retailerName;
		this.retailerAddress = retailerAddress;
		this.distToRetaDate = distToRetaDate;
	}

}
package MangoSupplyChain;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.shim.ChaincodeException;
import org.hyperledger.fabric.shim.ChaincodeStub;
import com.owlike.genson.Genson;

@Contract(name = "MangoSupplyChain", info = @Info(title = "MangoSupplyChain contract", description = "A supply chain chaincode", version = "0.0.1-SNAPSHOT"))

@Default
public final class MangoSupplyChain implements ContractInterface {

	private final Genson genson = new Genson();

	private enum MangoSupplyChainErrors {
		MANGO_ALREADY_EXIST, MANGO_NOT_EXIST
	}

	/**
	 * Initilize the ledger with one entry
	 *
	 * @param ctx the transaction context
	 */
	@Transaction()
	public void initLedger(final Context ctx) {

		ChaincodeStub stub = ctx.getStub();
		Mango mango = new Mango("3456721", "Kesari mango","Ram", "Maharashtra","05May2022","Vishal","Mumbai", "06May2022","Sunil", "Thane","07May2022");
		String mangoState = genson.serialize(mango);
		stub.putStringState("3456721", mangoState);
	}

	/**
	 * Add new product(Mango) to the ledger.
	 *
	 * @param ctx the transaction context
	 * @param id the product id of the mango
	 * @param description the description of the mango
	 * @param producerName producer or farmer name
	 * @param producerAddress producer or farmer address
	 * @param harvestdate harvestdate of the mango
	 * @return the Mango details
	 */

	@Transaction()
	public Mango addMango(final Context ctx, final String id, final String description, 
			final String producerName,final String producerAddress, final String harvestDate) {

		ChaincodeStub stub = ctx.getStub();

		String mangoState = stub.getStringState(id);

		if (!mangoState.isEmpty()) {
			Mango mango = genson.deserialize(mangoState, Mango.class);
			if (mango.getProductId() == id) {
				String errorMessage = String.format("Mango %s with same product id already logged to ledger", id);
				System.out.println(errorMessage);
				throw new ChaincodeException(errorMessage,
						MangoSupplyChainErrors.MANGO_ALREADY_EXIST.toString());
			}
		}
		Mango mgo = new Mango(id, description, producerName, producerAddress, harvestDate, "", "", "","","","");
		mangoState = genson.serialize(mgo);
		stub.putStringState(id, mangoState);
		return mgo;
	}

	/**
	 * Transfer Mango Ownership to distributer from producer.
	 *
	 * @param ctx the transaction context
	 * @param id product Id of the Mango
	 * @param distributerName distributer name
	 * @param distributerAddress distributer address
	 * @param transferDate transaction date between distributer and producer
	 * @return the product id
	 */
	@Transaction()
	public String updateDistributer(final Context ctx, final String id, final String distributerName, final String distributerAddress,
			final String transferDate) {
		ChaincodeStub stub = ctx.getStub();

		String mangoState = stub.getStringState(id);

		if (mangoState.isEmpty()) {
			String errorMessage = String.format("Mango with %s product Id does not exist  ", id);
			System.out.println(errorMessage);
			throw new ChaincodeException(errorMessage, MangoSupplyChainErrors.MANGO_NOT_EXIST.toString());
		}

		Mango mango = genson.deserialize(mangoState, Mango.class);

		Mango updatedMangoRecord = new Mango(mango.getProductId(),mango.getProductDescription(), mango.getProducerName(),
				mango.getProducerAddress(),mango.getHarvestDate(), distributerName, distributerAddress, transferDate,"","","");

		String newMangoState = genson.serialize(updatedMangoRecord);

		stub.putStringState(id, newMangoState);

		return mango.getProductId();
	}
	
	/**
	 * Transfer Mango Ownership to retailer from distributer.
	 *
	 * @param ctx the transaction context
	 * @param id product Id of the Mango
	 * @param retailerName retailer name
	 * @param retailerAddress retailer address
	 * @param transferDate transaction date between distributer and retailer
	 * @return the product id
	 */
	@Transaction()
	public String updateRetailer(final Context ctx, final String id, final String retailerName, final String retailerAddress,
			final String transferDate) {
		ChaincodeStub stub = ctx.getStub();

		String mangoState = stub.getStringState(id);

		if (mangoState.isEmpty()) {
			String errorMessage = String.format("Mango with %s product Id does not exist  ", id);
			System.out.println(errorMessage);
			throw new ChaincodeException(errorMessage, MangoSupplyChainErrors.MANGO_NOT_EXIST.toString());
		}

		Mango mango = genson.deserialize(mangoState, Mango.class);

		Mango updatedMangoRecord = new Mango(mango.getProductId(),mango.getProductDescription(), mango.getProducerName(),
				mango.getProducerAddress(),mango.getHarvestDate(), mango.getDistributerName(), mango.getDistributerAddress(),
				mango.getDistToRetaDate(),retailerName,retailerAddress,transferDate);

		String newMangoState = genson.serialize(updatedMangoRecord);

		stub.putStringState(id, newMangoState);

		return mango.getProductId();
	}


	/**
	 * Retrieves Mango product details from the ledger.
	 *
	 * @param ctx the transaction context
	 * @param id product Id of the Mango
	 * @return Mango supplychain details
	 */
	@Transaction()
	public Mango viewMangoDetails(final Context ctx, final String id) {
		ChaincodeStub stub = ctx.getStub();
		String mangoState = stub.getStringState(id);
		if (mangoState.isEmpty()) {
			String errorMessage = String.format("Mango with %s product Id does not exist  ", id);
			System.out.println(errorMessage);
			throw new ChaincodeException(errorMessage, MangoSupplyChainErrors.MANGO_NOT_EXIST.toString());
		}

		Mango mango = genson.deserialize(mangoState, Mango.class);
		return mango;
	}
}
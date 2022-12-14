# Mango-Supply-Chain-Management--chaincode
 
 
 Description:

Many people across the globe are getting sick due to the lack of food hygiene. A better tracking technique is required to trace back the origin of the food item so that the end user can authenticate food items and consume them without any worry.


Traditional Supply Chain:

The main reason for classical supply chain inefficiency is the lack of transparency
and reliable reporting. Many companies suffer from the lack of visibility regarding the entire supply chain of their products, and hence lose an immediate competitive advantage over competitors in their industries.

In the traditional supply chain models, the information about an entity is not fully transparent to others, which leads to inaccurate reports and a lack of interoperability. Emails and printed documents provide certain information, but still can’t contain fully detailed visibility and traceability information since the products across the entire supply chain are hard to trace. It is almost impossible for the consumer to know the true value of the product they purchased.



Solution using Hyperledger Blockchain:

The blockchain is a transparent, immutable, and secure decentralized system, it is considered to be a game-changing solution for traditional supply chain industries. Hyperledger Fabric is a blockchain framework implementation and one of the Hyperledger projects hosted by The Linux Foundation. Intended as a foundation for developing applications or solutions with a modular architecture, Hyperledger Fabric allows components, such as consensus and membership services, to be plug-and play. Hyperledger Fabric leverages container technology to host smart contracts called
“chaincode” that comprise the application logic of the system. It can help to build an effective supply chain system by improving the following areas:

i)Tracking the products in the entire chain
ii)Verifying and authenticating the products in the chain
iii)Sharing the entire chain information between supply chain actors 
iv)Providing better auditability

Hyperledger Fabric is different from blockchains such as Ethereum or Bitcoin, not only in its type or because it is currency-agnostic, but also in terms of its internal machinery. In a typical Hyperledger network we have the following key elements:

i) Ledger: This stores a chain of blocks, which keeps all immutable historical records of all state transitions.
ii) Nodes: These are the logical entities of the blockchain. There are three types of nodes :
iii) Client: Clients are applications that act on behalf of a user to submit transactions to the network.
iv) Peer: This is an entity that commits transactions and maintains the ledger state.
v) Orderer: This creates a shared communication channel between clients and peers, and it packages blockchain transactions into blocks and sends them to committing peers.
 

Together with these key elements, Hyperledger Fabric is based on the following key design features:

i) Chaincode: Chaincode is a similar concept to a smart contract in other networks such as Ethereum. It is a program written in a higher level language, executing against the ledger’s current state database.
ii) Channels: A channel is a private communication subnet for sharing confidential information between multiple network members. Each transaction is executed on the channel which is only visible to the authenticated and authorized parties.
iii) Endorsers: These validate transactions and invoke chaincode, sending back the endorsed transaction results to the calling applications.
iv) MSP: This provides identity validation and authentication processes by issuing and validating certificates. It identifies which certification authorities (CAs) are trusted to define the members of a trust domain, and determines the specific roles an actor might play (member, admin, and so on).



Background of the Mango supply chain:

Food quality and safety is one of the hot topics today where everyone is concerned about the food quality that they are consuming.

Food items like fruits generally don’t have any expiry date mentioned so it becomes really important to understand the origin of these food items and understand when the farmer sent it to the distributor and so on. Generally, the below cycle is followed in supply chain for fruit items:

Producer: The producer can harvest fruits, sell them to distributors, and track authenticity.
Distributor: The distributor can buy the fruits, distribute them, and track authenticity.
Retailer: The retailer can buy the fruits, put them for sale, and track authenticity.
Consumer: The consumer can buy the fruits and track authenticity.
 

Features of the application:

Mango as an asset has the following parameters:

productId: Asset Id
productDescription: Description of the asset
producerName: Producer or farmer name
producerAddress: Producer or farmer address
harvestDate: Harvest date
distributorName: Distributor name
distributorAddress: Distributor address
prodToDistDate: Producer to distributor transfer date
retailerName: Retailer name
retailerAddress: Retailer address
distToRetaDate: Distributor to retailer transfer date
 

1. Add a new asset (mango) to the ledger:

This function is used to add a new asset (mango) to the ledger. This function is called by the producer or farmer by using the below parameters:

Input parameters:

             * @param ctx                        the transaction context

             * @param id                          the product id of the mango

             * @param description           the description of the mango

             * @param producerName    producer or farmer name

             * @param producerAddress producer or farmer address

             * @param harvestdate          harvest date of the mango

             * @return the mango details

             */

This function does the following check as well:

Same asset with the same product ID does not exist already
 

 2. Transfer the asset to distributor from producer:

This function helps to transfer the asset from producer (farmer) to distributor.

Input parameters:

       * @param ctx                                    the transaction context

       * @param id                                      product ID of the mango

       * @param distributorName              distributor name

       * @param distributorAddress           distributor address

       * @param transferDate                    transaction date between distributor and producer

       * @return the product id

       */

This function does the following check as well:

The asset should be present in the ledger.
 

 3. Transfer the asset to retailer from distributor:

This function helps to transfer mango ownership to a retailer from a distributor.

 Input parameters:

       * @param ctx                       the transaction context

       * @param id                         product ID of the mango

       * @param retailerName       retailer name

       * @param retailerAddress    retailer address

       * @param transferDate        transaction date between distributor and retailer

       * @return the product id

       */

This function does the following check as well:

The asset should be present in the ledger.
 

4. View asset details from ledger:

This function helps to retrieve asset product details from the ledger.

      Input parameters

      * @param ctx    the transaction context

      * @param id       product Id of the mango

      * @return            mango supply chain details

*/


Technologies used:

i)IDE tool: Eclipse
ii)Chaincode language: Java
iii)Build automation tool: Gradle
iv)Blockchain: Hyperledger Fabric
v)Server: Test network






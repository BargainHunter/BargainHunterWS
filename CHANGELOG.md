## v0.0.1

* Added Hibernate to Spring
* Added Entities(`Store`, `Offer`)
* Added Repositories(`IStoreRepository`, `IOfferRepository`)
* Added RestControllers(`StoreController`, `OfferController`)
* Added methods to `StoreController`
    
    <table>
        <tr>
            <th>Method</th>
            <th>Mapping</th>
            <th>Description</th>
        </tr>
        <tr>
            <td><code>getAllStores</code></td>
            <td><code>/stores</code></td>
            <td>Returns list of all stores</td>
        </tr>
        <tr>
            <td><code>getAllStore</code></td>
            <td><code>/store/{id}</code></td>
            <td>Returns one specific store by Id</td>
        </tr>
    </table>

* Added methods to `OfferController`
    
    <table>
        <tr>
            <th>Method</th>
            <th>Mapping</th>
            <th>Description</th>
        </tr>
        <tr>
            <td><code>getOffers</code></td>
            <td><code>/offers</code></td>
            <td>Returns list of all offers</td>
        </tr>
        <tr>
            <td><code>getOffer</code></td>
            <td><code>/offers/{id}</code></td>
            <td>Returns one specific offer by Id</td>
        </tr>
    </table>

* Added seperated contexts(`application-context.xml`, `text-context.xml`)

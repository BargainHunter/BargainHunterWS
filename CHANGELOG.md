## v0.0.4

* Added Entities(`Branch`, `Category`, `Subcategory`)
* Added Default JPA Repositories(`IBranchRepository`, `ICategoryRepository`, `ISubcategoryRepository`)
* Removed RestControllers(`StoreService`, `OfferService`)
* Removed Controllers(`StoreController`, `OfferController`)
* Added Controller `DistanceController` for distance calculation
    
    <table>
        <tr>
            <th>Return</th>
            <th>Method</th>
        </tr>
        <tr>
            <td><code>double</code></td>
            <td><code>deg2rad(double deg)</code></td>
        </tr>
        <tr>
            <td><code>double</code></td>
            <td><code>rad2deg(double rad)</code></td>
        </tr>
        <tr>
            <td><code>double</code></td>
            <td><code>calcDistance(double lat1, double lon1, double lat2, double lon2)</code></td>
        </tr>
    </table>

* Added Controllers(`SearchController`, `CategoryController`)
* Added methods to `SearchController`
    
    <table>
        <tr>
            <th>Return</th>
            <th>Method</th>
        </tr>
        <tr>
            <td><code>SearchInRadiusDTO</code></td>
            <td><code>getAllBranchesWithStoresAndOffersInRadiusDTO(Double latitude, Double longitude, Double radius)</code></td>
        </tr>
        <tr>
            <td><code>SearchInRadiusDTO</code></td>
            <td><code>createSearchInRadiusDTO(Double latitude, Double longitude, Double radius, Collection&lt;Store&gt; stores)</code></td>
        </tr>
        <tr>
            <td><code>StoreDTO</code></td>
            <td><code>createStoreDTO(Store store)</code></td>
        </tr>
        <tr>
            <td><code>OfferDTO</code></td>
            <td><code>createOfferDTO(Offer offer)</code></td>
        </tr>
        <tr>
            <td><code>Collection&lt;OfferSubcategoryDTO&gt;</code></td>
            <td><code>createOfferSubcategoryDTO(Collection&lt;Subcategory&gt; subcategories)</code></td>
        </tr>
    </table>

* Added methods to `CategoryController`
    
    <table>
        <tr>
            <th>Return</th>
            <th>Method</th>
        </tr>
        <tr>
            <td><code>CategoriesDTO</code></td>
            <td><code>getAllCategoryDTOs()</code></td>
        </tr>
        <tr>
            <td><code>CategoriesDTO</code></td>
            <td><code>createCategoryDTOs(Collection&lt;Category&gt; categories)</code></td>
        </tr>
        <tr>
            <td><code>CategoryDTO</code></td>
            <td><code>createCategoryDTO(Category category)</code></td>
        </tr>
        <tr>
            <td><code>Collection&lt;SubcategoryDTO&gt;</code></td>
            <td><code>createSubcategoryDTOs(Collection&lt;Subcategory&gt; subcategories)</code></td>
        </tr>
        <tr>
            <td><code>SubcategoryDTO</code></td>
            <td><code>createSubcategoryDTO(Subcategory subcategory)</code></td>
        </tr>
    </table>

* Added RestControllers(`SearchService`, `CategoryService`)
* Added DTOs for `CategoryService`(`CategoriesDTO`, `CategoryDTO`, `SubcategoryDTO`)
* Added DTOs for `SearchService`(`SearchInRadiusDTO`, `BranchDTO`, `StoreDTO`, `OfferDTO`, `OfferSubcategoryDTO`)
* Added methods to `SearchService`
    
    <table>
        <tr>
            <th>Return</th>
            <th>Method</th>
            <th>Mapping</th>
        </tr>
        <tr>
            <td><code>HttpEntity&lt;SearchInRadiusDTO&gt;</code></td>
            <td><code>getAllBranchesWithStoresAndOffersInRadius(Double latitude, Double longitude, Double radius)</code></td>
            <td><code>/search_in_radius?latitude=?&longitude=?&radius=?</code></td>
        </tr>
    </table>

* Added method to `CategoryService`
    
    <table>
        <tr>
            <th>Return</th>
            <th>Method</th>
            <th>Mapping</th>
            <th>Description</th>
        </tr>
        <tr>
            <td><code>HttpEntity&lt;CategoriesDTO&gt;</code></td>
            <td><code>getAllCategoryDTOs()</code></td>
            <td><code>/categories</code></td>
            <td>Returns list of all categories with subcategories</td>
        </tr>
    </table>

## v0.0.3

* Changed JDK version to 8
* Added method to `StoreService`
    
    <table>
        <tr>
            <th>Return</th>
            <th>Method</th>
            <th>Mapping</th>
            <th>Description</th>
        </tr>
        <tr>
            <td><code>ResponseEntity&lt;Collection&lt;StoreDTO&gt;&gt;</code></td>
            <td><code>getAllStoresInRadius(double latitude, double longitude, double radius)</code></td>
            <td><code>/stores?latitude=?&longitude=?&radius=?</code></td>
            <td>Returns list of all stores in a specific radius</td>
        </tr>
    </table>

* Added Entity `About`
* Added RestController `AboutService`
* Added method to `AboutService`
    
    <table>
        <tr>
            <th>Return</th>
            <th>Method</th>
            <th>Mapping</th>
            <th>Description</th>
        </tr>
        <tr>
            <td><code>About</code></td>
            <td><code>about()</code></td>
            <td><code>/about</code></td>
            <td>Returns information about web application</td>
        </tr>
    </table>

## v0.0.2

* Added DTOs(`StoreDTO`, `OfferDTO`)
* Added Controllers(`StoreController`, `OfferController`)
    
    <table>
        <tr>
            <th>Return</th>
            <th>Method</th>
        </tr>
        <tr>
            <td><code>Collection&lt;StoreDTO&gt;</code></td>
            <td><code>getAllStoresDTOs()</code></td>
        </tr>
        <tr>
            <td><code>StoreDTO</code></td>
            <td><code>getStore(int id)</code></td>
        </tr>
        <tr>
            <td><code>Collection&lt;StoreDTO&gt;</code></td>
            <td><code>createDTOs(Collection&lt;Store&gt; stores)</code></td>
        </tr>
        <tr>
            <td><code>StoreDTO</code></td>
            <td><code>createDTO(Store store)</code></td>
        </tr>
    </table>

* Added Entity(`Company`)
* Added Default JPA Repository(`ICompanyRepository`)
* Migrated from `application.properties` to `application-context.xml`
* Changed return type of `RestControllers` to `ResponseEntity<>`
* Changed packaging extension from `.jar` to `.war`

## v0.0.1

* Added Hibernate to Spring
* Added Entities(`Store`, `Offer`)
* Added Default JPA Repositories(`IStoreRepository`, `IOfferRepository`)
* Added RestControllers(`StoreService`, `OfferService`)
* Added methods to `StoreService`
    
    <table>
        <tr>
            <th>Return</th>
            <th>Method</th>
            <th>Mapping</th>
            <th>Description</th>
        </tr>
        <tr>
            <td><code>Collection&lt;Store&gt;</code></td>
            <td><code>getAllStores()</code></td>
            <td><code>/stores</code></td>
            <td>Returns list of all stores</td>
        </tr>
        <tr>
            <td><code>Store</code></td>
            <td><code>getOneById(long storeId)</code></td>
            <td><code>/stores/{storeId}</code></td>
            <td>Returns one specific store by Id</td>
        </tr>
    </table>

* Added methods to `OfferService`
    
    <table>
        <tr>
            <th>Return</th>
            <th>Method</th>
            <th>Mapping</th>
            <th>Description</th>
        </tr>
        <tr>
            <td><code>Collection&lt;Offer&gt;</code></td>
            <td><code>getAll()</code></td>
            <td><code>/offers</code></td>
            <td>Returns list of all offers</td>
        </tr>
        <tr>
            <td><code>Offer</code></td>
            <td><code>getOneById(long id)</code></td>
            <td><code>/offers/{offerId}</code></td>
            <td>Returns one specific offer by Id</td>
        </tr>
        <tr>
            <td><code>Collection&lt;Offer&gt;</code></td>
            <td><code>getAllFromStore(long storeId)</code></td>
            <td><code>/stores/{storeId}/offers</code></td>
            <td>Returns list of all offers that belongs to one store</td>
        </tr>
    </table>

* Added seperated contexts(`application-context.xml`, `text-context.xml`)

package br.com.ecarrara.neom.nearearthobjects.presentation.view;

import java.util.List;

import br.com.ecarrara.neom.foundations.presentation.view.LoadDataView;
import br.com.ecarrara.neom.nearearthobjects.data.entity.NearEarthObject;
import br.com.ecarrara.neom.nearearthobjects.presentation.model.NearEarthObjectModel;

/**
 * View that represents a listing of Near Earth Objects
 */
public interface NearEarthObjectsListView extends LoadDataView {

    void renderNearEarthObjectsList(List<NearEarthObject> nearEarthObjectModels);

}

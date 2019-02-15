package nl.incredapple.reboot;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cleveroad.slidingtutorial.Direction;
import com.cleveroad.slidingtutorial.PageOptions;
import com.cleveroad.slidingtutorial.TransformItem;
import com.cleveroad.slidingtutorial.TutorialFragment;
import com.cleveroad.slidingtutorial.TutorialOptions;
import com.cleveroad.slidingtutorial.TutorialPageOptionsProvider;
import com.cleveroad.slidingtutorial.TutorialSupportFragment;

///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link IntroductionFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link IntroductionFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public abstract class IntroductionFragment extends AppCompatActivity {

    protected abstract Fragment createFragment();
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            fragment = createFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }

        final TutorialSupportFragment tutorialFragment = TutorialSupportFragment.newInstance(tutorialOptions);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, tutorialFragment)
                .commit();

        intentIntro ();
    }

//    final TutorialOptions tutorialOptions = TutorialSupportFragment.newTutorialOptionsBuilder(context)
//            .setPagesCount(4)
//            .setTutorialPageProvider()
//            .build();


    private void intentIntro (){
        Intent nextPageIntent = new Intent(IntroductionFragment.this, GoalActivity.class);
        startActivity(nextPageIntent);
    }


    final TutorialPageOptionsProvider tutorialPageOptionsProvider = new TutorialPageOptionsProvider() {
        @NonNull
        @Override
        public PageOptions provide(int position) {
            @LayoutRes int pageLayoutResId;
            TransformItem[] tutorialItems;
            switch (position) {
                case 0: {
                    pageLayoutResId = R.layout.fragment_page_first;
                    tutorialItems = new TransformItem[]{
//                            TransformItem.create(R.id.ivFirstImage, Direction.LEFT_TO_RIGHT, 0.2f),
////
//                    TransformItem.create(R.id.ivEighthImage, Direction.RIGHT_TO_LEFT, 0.07f)
				};
                    break;
                }
                case 1: {
                    pageLayoutResId = R.layout.fragment_page_second;
                    tutorialItems = new TransformItem[]{
//                            TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f),
//
//                    TransformItem.create(R.id.ivEighthImage, Direction.LEFT_TO_RIGHT, 0.07f)
				};
                    break;
                }
                case 2: {
                    pageLayoutResId = R.layout.fragment_page_third;
                    tutorialItems = new TransformItem[]{
//                            TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f),
//
//                    TransformItem.create(R.id.ivSeventhImage, Direction.LEFT_TO_RIGHT, 0.14f)
				};
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unknown position: " + position);
                }
            }

            return PageOptions.create(pageLayoutResId, position, tutorialItems);
        }
    };

    final TutorialOptions tutorialOptions = TutorialFragment.newTutorialOptionsBuilder(context)
                .setTutorialPageProvider(tutorialPageOptionsProvider)
                .build();

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;
//
//    public IntroductionFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment IntroductionFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static IntroductionFragment newInstance(String param1, String param2) {
//        IntroductionFragment fragment = new IntroductionFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        TextView textView = new TextView(getActivity());
//        textView.setText(R.string.hello_blank_fragment);
//        return textView;
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}

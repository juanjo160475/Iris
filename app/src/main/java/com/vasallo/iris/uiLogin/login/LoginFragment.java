package com.vasallo.iris.uiLogin.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.vasallo.iris.MainActivity;
import com.vasallo.iris.MainActivityLogin;
import com.vasallo.iris.R;
import com.vasallo.iris.databinding.FragmentLoginBinding;
import com.vasallo.iris.modelo.DbSqlLite;
import com.vasallo.iris.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class LoginFragment extends Fragment {

    private EditText emailView, passView;
    private Button ingresar, cerrar,registrar;
    private TextView sesion;
    private FragmentLoginBinding binding;
    DbSqlLite db;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ingresar = binding.loginIngresar;
        emailView = binding.loginEmail;
        passView = binding.loginPassword;
        sesion = binding.loginSesion;
        ingresar = binding.loginIngresar;
        cerrar = binding.loginCerrar;
        registrar=binding.loginRegistrar;
        emailView.setText("");
        passView.setText("");


        db = Room.databaseBuilder(getActivity().getApplicationContext(),
                DbSqlLite.class, "dbSqlLite").allowMainThreadQueries().build();

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarsesion();
            }
        });

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cerrarSesion();
            }
        });
registrar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        registrarse();
    }
});

    }

    private void registrarse() {

        NavHostFragment.findNavController(LoginFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment);
    }

    public void iniciarsesion() {
        List<Usuario> usuarios;
        usuarios = db.userDao().getAll();

if (usuarios.size()!=0) {


    if (emailView.getText().toString().equals("")) {
        emailView.setError("Ingresar email");
    } else if (passView.getText().toString().equals("")) {
        passView.setError("Ingresar password");
    } else {
        String email = emailView.getText().toString().trim();
        String password = passView.getText().toString().trim();


        for (Usuario us : usuarios
        ) {
            Log.e("mostrarUsuarios: ", us.getNombre());
            Log.e("mostrarUsuarios: ", us.getApellido());
            Log.e("mostrarUsuarios: ", us.getId());
            Log.e("mostrarUsuarios: ", us.getCorreo());
            Log.e("mostrarUsuarios: ", us.getPass());

        }

        for (Usuario us : usuarios
        ) {


            if (password.equals(us.getPass()) &&
                    email.equals(us.getCorreo())) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getActivity(), "Usuario o contraseña incorrecta",
                        Toast.LENGTH_SHORT).show();
            }
        }


    }
} else{
            Toast.makeText(getActivity(), "Aún no te has registrado",
                    Toast.LENGTH_SHORT).show();
        }


/*            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getActivity(), "bienvenido.",
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(user);
                                Intent intent = new Intent(getActivity(), Main2Activity.class);
                                //intent.putExtra("usuario", user.getUid());
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(getActivity(), "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                Toast.makeText(getActivity(), task.getException().toString(),
                                        Toast.LENGTH_LONG).show();
                                // updateUI(null);
                            }

                            // ...
                        }
                    });*/
        }



    public  void cerrarSesion(){

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}